package com.qht.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要下载的文件名
        String downloadFileName = "2.jpg";
        //读取要下载的文件内容
        ServletContext servletContext = getServletContext();
        //获取下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println(mimeType);
        //在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        //还要告诉客户端收到的数据是用于下载使用（还是使用响应头）
        // Content-Disposition 响应头，表示收到的数据怎么处理
        // attachment 表示附件，表示下载使用
        // filename= 表示指定下载的文件名
        //不同浏览器编码不一样
        String ua = req.getHeader("User-Agent");
        System.out.println(ua);
        if(ua.contains("Firefox")){
            String str = "attachment; fileName=" + "=?utf-8?B?"
                    + new BASE64Encoder().encode("悬崖.jpg".getBytes("utf-8")) + "?=";
            resp.setHeader("Content-Disposition", str);
        }else{
            //除了火狐浏览器
            String str = "attachment; filename=" + URLEncoder.encode("悬崖.jpg","UTF8");
            resp.setHeader("Content-Disposition", str);
        }

        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        //获取响应输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //把下载的文件传输给客户端
        IOUtils.copy(resourceAsStream,outputStream);


    }
}
