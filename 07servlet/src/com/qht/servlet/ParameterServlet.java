package com.qht.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        //获取请求模式
        System.out.println(method);
        //获取请求头
        String parameter = req.getHeader("User-Agent");
        System.out.println(parameter);

        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        String hobby = req.getParameter("hobby");
        //如果有多个值
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("请求参数"+username+" "+password+" "+ Arrays.toString(hobbies));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求体字符集 解决post  请求的中文乱码问题
        //在请求参数之前调用才有效
        req.setCharacterEncoding("UTF8");
        String method = req.getMethod();
        //获取请求模式
        System.out.println(method);
        //获取请求头
        String parameter = req.getHeader("User-Agent");
        System.out.println(parameter);

        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        String hobby = req.getParameter("hobby");
        //如果有多个值
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("请求参数"+username+" "+password+" "+ Arrays.toString(hobbies));
    }
}
