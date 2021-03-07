package com.qht.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("key1","qq");
        //设置相应状态码
//        resp.setStatus(302);
//        resp.setHeader("location","http://localhost:8080/07servlet/r2");
//        resp.setHeader("location","http://www.61.com");

        //第二中方案 推荐
        resp.sendRedirect("http://localhost:8080/07servlet/r2");
    }

}
