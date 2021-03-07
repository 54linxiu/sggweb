package com.qht.servlet;

import com.qht.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieServlet extends BaseServlet {
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "aa");
        cookie.setPath(req.getContextPath()+"/aa");
        resp.addCookie(cookie);
        resp.getWriter().write("带有路径的cookie");
    }

        /**
         * 设置cookie 保存一个小时
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    protected void Life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie key1 = CookieUtils.findCookie("key1", req.getCookies());
        key1.setMaxAge(60*60);
        resp.addCookie(key1);
        resp.getWriter().write("一个小时");
    }
        /**
         * 立即删除
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    protected void deleteNowLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie key1 = CookieUtils.findCookie("key1", req.getCookies());
        key1.setMaxAge(0);
        resp.addCookie(key1);
        resp.getWriter().write("立即删除");
    }
        /**
         * 默认的会话级别的 Cookie
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("default", "default");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
        resp.getWriter().write("默认");
    }

    /**
     * 修改cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*// 方案一：
        // 1、先创建一个要修改的同名的 Cookie 对象
        // 2、在构造器，同时赋于新的 Cookie 值。
        Cookie cookie = new Cookie("key1", "newValue1");
        // 3、调用 response.addCookie( Cookie ); 通知 客户端 保存修改
        resp.addCookie(cookie);*/

//        方案二：
//        1、先查找到需要修改的 Cookie 对象
        Cookie key1 = CookieUtils.findCookie("key1", req.getCookies());
        if(key1 != null){
//        2、调用 setValue()方法赋于新的 Cookie 值。
            key1.setValue("23124");
//        3、调用 response.addCookie()通知客户端保存修改
            resp.addCookie(key1);
            resp.getWriter().write("修改成功");
        }



    }

    /**
     * 获取cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().write(cookie.getName() + ":" + URLDecoder.decode(cookie.getValue(), "UTF-8") + "</br>");
        }

        Cookie adsf = CookieUtils.findCookie("adsf", cookies);
        if (adsf != null) {
            resp.getWriter().write(adsf.getName());
        }
    }

    /**
     * 创建cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建cookie
        Cookie cookie1 = new Cookie("adsf", URLEncoder.encode("林秀", "UTF-8"));
        //保存
        resp.addCookie(cookie1);
        //创建cookie
        Cookie cookie2 = new Cookie("key1", "adf");
        //保存
        resp.addCookie(cookie2);
        //
        resp.getWriter().write("富士山下");


    }
}
