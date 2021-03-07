package com.qht.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet{


    protected void setLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置session超时时间
        req.getSession().setMaxInactiveInterval(3);
        resp.getWriter().write("3秒");
    }
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //让当前 Session 会话马上超时无效
        req.getSession().invalidate();
        resp.getWriter().write("当前session销毁");
    }
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取 Session 的超时时间
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("时间"+maxInactiveInterval);
    }
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("保存数据成功");
    }
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("数据是"+attribute);
    }
    protected void createGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建获取Session对象
        HttpSession session = req.getSession();
        //判断是否是新创建的
        boolean aNew = session.isNew();
        //获取id
        String id = session.getId();
        resp.getWriter().write("得到session id:"+id+"</br>");
        resp.getWriter().write("新session?:"+aNew);
    }
}
