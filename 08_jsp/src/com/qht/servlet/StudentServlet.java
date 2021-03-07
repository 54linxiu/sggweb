package com.qht.servlet;

import com.qht.dao.StudentDao;
import com.qht.dao.imp.StudentImp;
import com.qht.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends HttpServlet {
    private StudentDao d= new StudentImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ss");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String sname = req.getParameter("sname");
        List<Student> likestu = d.getLikestu(sname);
        req.setAttribute("sname",likestu);
        req.getRequestDispatcher("/test/showStudent2.jsp").forward(req,resp);
    }
}
