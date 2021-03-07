package com.qht.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getOutputStream();只能使用一种流
//        resp.setCharacterEncoding("UTF8");
        resp.setHeader("content-type","text/html; charset=utf-8");//此方法一定要在获取流对象才有效
        resp.getWriter().write("大哥大嫂过年好");


    }
}
