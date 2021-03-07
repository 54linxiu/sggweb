package com.qht.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Contextservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取web.xml中配置的上下文参数context-param
        ServletContext servletContext = getServletConfig().getServletContext();

        System.out.println("context-param的参数"+servletContext.getInitParameter("user"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取web.xml中配置的上下文参数context-param
        ServletContext servletContext = getServletConfig().getServletContext();

        System.out.println("context-param的参数"+servletContext.getInitParameter("user"));
        //当前工程路径 格式 /工程路径
        System.out.println("工程路径"+servletContext.getContextPath());
        //获取工程部署后在服务器硬盘上绝对路径
        System.out.println(servletContext.getRealPath("/css"));
        System.out.println(servletContext.getRealPath("/imgs/3.jpg"));
    }
}
