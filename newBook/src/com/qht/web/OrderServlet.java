package com.qht.web;

import com.qht.pojo.*;
import com.qht.service.OrderService;
import com.qht.service.impl.OrderServiceImp;
import com.qht.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImp();

    /**
     * 更多信息
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void more(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取订单号
        String orderId = req.getParameter("orderId");
        //调用service 获取订单详细信息
        List<OrderItme> orderItmelist = orderService.getOrderItmelist(orderId);
        Field[] declaredFields = OrderItme.class.getDeclaredFields();

        //保存
        req.setAttribute("orderItmelist", orderItmelist);
        //转发
        req.getRequestDispatcher("/pages/order/details.jsp").forward(req, resp);

    }

    /**
     * 发货
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ship(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取订单id
        String orderId = req.getParameter("orderId");
        //修改状态
        orderService.updateStatus(orderId);

        /*//获取所有订单
        List<Order> orders = orderService.getOrder();
        //更新所有订单
        req.setAttribute("allOrder", orders);*/

        //重定向
        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=showOrderAll");
    }

    /**
     * 用户个人订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showMyOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户信息
        String userid = req.getParameter("userid");//可以访问session中的user类
        //获取用service 获取信息
        List<Order> userOrder = orderService.getOrderItmelistbyuserId(WebUtils.parseInt(userid, 0));
        //保存用户订单
        req.setAttribute("userOrder", userOrder);

        //转发
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);


    }

    protected void showOrderAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取所有订单
        List<Order> orders = orderService.getOrder();
        //保存所有订单
        req.setAttribute("allOrder", orders);

        //转发
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
    }


    /**
     * 生成订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车 用户id
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        Integer userId = user.getId();


        //调用OrderserviceImp.creatOrder(Cart cart, Integer userId)生成订单
        String orderId = null;

        orderId = orderService.creatOrder(cart, userId);

        //保存单号
        req.getSession().setAttribute("orderId", orderId);
        //重定向
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    /**
     * 分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void fy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String start = req.getParameter("start");
        String size = req.getParameter("size");
        User user = (User) req.getSession().getAttribute("user");
        Page<Order> pagination = orderService.pagination(WebUtils.parseInt(start, 1), WebUtils.parseInt(size, 4), user.getId());
        pagination.setUrl("orderServlet?action=fy&start=");
        System.out.println(pagination);
        //保存分页
        req.setAttribute("orderpage", pagination);
        //请求转发
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }
}
