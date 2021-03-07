package com.qht.web;

import com.qht.pojo.User;
import com.qht.service.UserService;
import com.qht.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        //1获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repwd = req.getParameter("repwd");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //检查验证码是否正确 验证码写死 abcde
        if("abcde".equalsIgnoreCase(code)){
            //验证码正确 就判断用户名存不存在
            if (userService.existsUserUsername(username)){
                //用户已存在 不可用跳回注册页面
                //回显错误信息
                req.setAttribute("msg","用户已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                System.out.println("用户已存在"+username);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                //用户不存在 可以注册
                //调用service层保存到数据库
                userService.registUser(new User(null,username,password,email));
                System.out.println("注册成功");
                //跳到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else{
            //不正确
            //跳回注册页面
            //回显错误信息
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            System.out.println("验证码"+code+"错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }


    }
}
