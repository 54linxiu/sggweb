package com.qht.web;

import com.qht.pojo.User;
import com.qht.service.UserService;
import com.qht.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        req.setCharacterEncoding("UTF8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //验证账号 是否正确 调用service
        if (userService.login(new User(null, username, password, null)) == null) {
            req.setAttribute("msg","用户或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            req.removeAttribute("msg");//   疑问点
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
