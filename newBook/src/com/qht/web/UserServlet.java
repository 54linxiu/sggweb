package com.qht.web;

import com.google.gson.Gson;
import com.qht.pojo.User;
import com.qht.service.UserService;
import com.qht.service.impl.UserServiceImp;
import com.qht.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImp();

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        //调用service
        boolean existsUsername = userService.existsUserUsername(username);
        //把返回结果封装成为map
        Map<String,Object> map = new HashMap<>();
        map.put("existsUsername",existsUsername);

        //调用Gson 把map转换成json
        Gson gson = new Gson();
        String jsonstr = gson.toJson(map);

        //响应
        resp.getWriter().write(jsonstr);
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、销毁 Session 中用户登录的信息（或者销毁 Session）
//        req.getSession().invalidate();
        req.getSession().removeAttribute("user");
//        2、重定向到首页（或登录页面）。
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * 登陆功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取参数
//        req.setCharacterEncoding("utf-8");若已使用request获取请求参数，此时还没有设置过编码，Tomcat会设置默认Post请求参数编码为ISO8859_1
        String username = req.getParameter("username");

        String password = req.getParameter("password");
//        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        User user = userService.login(new User(null, username, password, null));
        //验证账号 是否正确 调用service
        if (user == null) {
            req.setAttribute("msg", "用户或密码错误");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            req.removeAttribute("msg");//   疑问点

            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String testCode = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
//        req.setCharacterEncoding("UTF-8");
        //1获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repwd = req.getParameter("repwd");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());


        if (testCode != null && code.equals(testCode)) {
            //验证码正确 就判断用户名存不存在
            if (userService.existsUserUsername(username)) {
                //用户已存在 不可用跳回注册页面
                //回显错误信息
                req.setAttribute("msg", "用户已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                System.out.println("用户已存在" + username);

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //用户不存在 可以注册
                //调用service层保存到数据库
                userService.registUser(user);
                System.out.println("注册成功");

                //保存信息
                req.getSession().setAttribute("user", user);
                //跳到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //不正确
            //跳回注册页面
            //回显错误信息
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            System.out.println("验证码" + code + "错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


}
