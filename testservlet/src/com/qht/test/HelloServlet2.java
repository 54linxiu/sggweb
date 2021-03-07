package com.qht.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 一般在实际项目开发中，都是使用继承 HttpServlet 类的方式去实现 Servlet 程序
 * 1、编写一个类去继承 HttpServlet 类
 * 2、根据业务需要重写 doGet 或 doPost 方法
 * 3、到 web.xml 中的配置 Servlet 程序的访问地址
 */
public class HelloServlet2 extends HttpServlet {
    /**
     * get请求操作
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("继承HttpServlet get请求");
    }

    /**
     * post请求操作
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("继承HttpServlet Post请求");
    }
}
