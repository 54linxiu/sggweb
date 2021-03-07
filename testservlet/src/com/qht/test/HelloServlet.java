package com.qht.test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("1 init");

        //获取servlet-name的值
        System.out.println("HelloServlet的别名"+servletConfig.getServletName());

        //获取初始化参数init-param
        System.out.println("获取username的值"+servletConfig.getInitParameter("username"));
        System.out.println("获取url的值"+servletConfig.getInitParameter("url"));
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet 欢迎你");
        HttpServletRequest hs = (HttpServletRequest) servletRequest;
        String method = hs.getMethod();

        if("GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }

    }

    /**
     * get请求操作
     */
    public void doGet(){
        System.out.println("get请求");
    }

    /**
     * post请求操作
     */
    public void doPost(){
        System.out.println("Post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("3 仅执行一次，在服务器端停止且卸载Servlet时执行该方法。当Servlet对象退出生命周期时，负责释放占用的资源。一个Servlet在运行service()方法时可能会产生其他的线程，因此需要确认在调用destroy()方法时，这些线程已经终止或完成。");
    }
}
