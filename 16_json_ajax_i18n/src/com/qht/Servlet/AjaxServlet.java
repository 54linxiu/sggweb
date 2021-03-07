package com.qht.Servlet;

import com.google.gson.Gson;
import com.qht.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet{


    protected void ajaxGetOrPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ajaxGetOrPost ajax请求到了");
        Student student = new Student(1, "重定");
        Gson gson = new Gson();
        String s = gson.toJson(student);
        System.out.println(s);
        resp.getWriter().write(s);



    }
    protected void ajaxJquery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ajaxJquery请求到了");
        Student student = new Student(1, "重定");
        Gson gson = new Gson();
        String s = gson.toJson(student);
        System.out.println(s);
        resp.getWriter().write(s);
    }
    protected void ajaxJqueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ajaxJqueryGet请求到了");
        Student student = new Student(1, "重定");
        Gson gson = new Gson();
        String s = gson.toJson(student);
        System.out.println(s);
        resp.getWriter().write(s);
    }
    protected void ajaxJqueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ajaxJqueryPost请求到了");
        Student student = new Student(1, "重定");
        Gson gson = new Gson();
        String s = gson.toJson(student);
        System.out.println(s);
        resp.getWriter().write(s);
    }
    protected void ajaxJqueryGetJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ajaxJqueryGetJson请求到了");
        Student student = new Student(1, "重定");
        Gson gson = new Gson();
        String s = gson.toJson(student);
        System.out.println(s);
        resp.getWriter().write(s);
    }
    protected void ajaxJquerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ajaxJquerySerialize请求到了");
        Student student = new Student(1, "重定");
        Gson gson = new Gson();
        String s = gson.toJson(student);
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        resp.getWriter().write(s);
    }
}
