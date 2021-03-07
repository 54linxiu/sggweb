package com.qht.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //获取session中的验证码
        String testcode = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        //删除session中的验证码
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
        String username = req.getParameter("username");
        String code = req.getParameter("code");

        if(testcode !=null && code.equals(testcode)){
            System.out.println("ok");
            resp.sendRedirect(req.getContextPath()+"/ok.jsp");
        }else{
            System.out.println("on");
        }
    }
}
