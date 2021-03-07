package com.qht.web;

import com.google.gson.Gson;
import com.qht.pojo.Book;
import com.qht.pojo.Cart;
import com.qht.pojo.CartItem;
import com.qht.service.BookService;
import com.qht.service.impl.BookServiceImp;
import com.qht.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet{

    private BookService bookService = new BookServiceImp();

    protected void changeQuantity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取id
        String id = req.getParameter("id");
        //获取数量
        String count = req.getParameter("count");
        //获取购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            // 修改数量
            cart.updateCount(WebUtils.parseInt(id, 0), WebUtils.parseInt(count, 1));
            //重定向
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

        /**
         * 删除所有商品
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    protected void clearItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

        /**
         * 删除购物车商品
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品id
        String id = req.getParameter("id");
        //获取session中的购物车
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart != null){
            cart.deleteItme(WebUtils.parseInt(id, 0));
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

        /**
         * 加入购物车
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品id
        String id = req.getParameter("id");
        //查询商品详细信息
        Book book = bookService.queryBook(WebUtils.parseInt(id, 0));
        //商品信息转化item
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //item放到购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        req.getSession().setAttribute("lastName", cartItem.getName());
        cart.addItem(cartItem);

        System.out.println(cart);

        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品id
        String id = req.getParameter("id");
        //查询商品详细信息
        Book book = bookService.queryBook(WebUtils.parseInt(id, 0));
        //商品信息转化item
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //item放到购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        cart.addItem(cartItem);

        System.out.println(cart);

        req.getSession().setAttribute("lastName", cartItem.getName());

        Map<String,Object> map = new HashMap<>();
        map.put("lastName", book.getName());
        map.put("totalCount",cart.getTotalCount());

        Gson gson = new Gson();
        String jsonStr = gson.toJson(map);

        resp.getWriter().write(jsonStr);
    }
}
