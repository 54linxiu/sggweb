package com.qht.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("Servlet1"+username);

        //准备转递到servlet2的数据
        req.setAttribute("key1","over");

        //设置转发路径
        // 斜杆代表 http://ip:potr/工程名/,映射IDEA代码web目录
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/from.html");

        //请求转发
        requestDispatcher.forward(req,resp);
    }
}
