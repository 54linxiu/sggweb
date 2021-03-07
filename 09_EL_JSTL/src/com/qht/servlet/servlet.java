package com.qht.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class servlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   /*     System.out.println("收到");
        ServletInputStream inputStream = request.getInputStream();
        byte[] buffer = new byte[1024>>2];
        int read = inputStream.read(buffer);
        System.out.println(new String(buffer,0,read));*/
        //先判断上传的数据是否为多段数据 只有多段数据才是文件上传
        if(ServletFileUpload.isMultipartContent(request)){

//            创建 FileItemFactory 工厂实现类
            FileItemFactory factory = new DiskFileItemFactory();
            // 创建用于解析上传数据的工具类 ServletFileUpload 类
            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
            try {
                // 解析上传的数据，得到每一个表单项 FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                // 循环判断，每一个表单项，是普通类型，还是上传的文件
                for (FileItem fileItem : list) {
                    if(fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单name名字"+fileItem.getFieldName());
                        //解决文字编码问题
                        System.out.println("表单value的值"+fileItem.getString("UTF8"));
                        System.out.println(fileItem.isInMemory());
                    }else{
                        //上传文件
                        System.out.println("表单name名字"+fileItem.getFieldName());
                        //上传文件名
                        System.out.println(fileItem.getName());
                        fileItem.write(new File("E:/"+fileItem.getName()));

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
