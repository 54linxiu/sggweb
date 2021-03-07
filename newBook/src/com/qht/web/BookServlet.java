package com.qht.web;

import com.qht.pojo.Book;
import com.qht.pojo.Page;
import com.qht.service.BookService;
import com.qht.service.impl.BookServiceImp;
import com.qht.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImp();

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取修改书本参数
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //调用bookService.updateBook()
        bookService.updateBook(book);
        //重定向  /manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数 图书编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //通过booService.queryBook查询
        Book book = bookService.queryBook(id);
        //保存到request域中
        req.setAttribute("book", book);
        //转发
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        //获取请求参数
        String id = req.getParameter("id");
        //将参数类型转换
        int intId = WebUtils.parseInt(id,0);
        //执行删除操作 booService
        bookService.deleteBook(intId);
        //重定向  /manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0)+1;
//        1、获取请求的参数==封装成为 Book 对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
//        2、调用 BookService.addBook()保存图书
        bookService.addBook(book);
//        3、跳到图书列表页面
// /manager/bookServlet?action=list
        //当用户提交完请求，浏览器会记录下最后一次请求的全部信息。当用户按下功能键 F5，就会发起浏览器记录的最后一次
        //请求。
// req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过bookservice获取全部图书信息
        List<Book> books = bookService.queryBooks();
        //把图书信息保存到request域中
        req.setAttribute("books", books);
        //请求转发pages/mananger/book_mananger.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求pageNO和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"),Page.PAGE_SIZE);
        //调用bookService.page()获取page对象
        Page<Book> page = bookService.page(pageNo,pageSize);

        page.setUrl("manager/bookServlet?action=page&pageNo=");
        //保存到request域中
        req.setAttribute("page", page);
        //请求转发pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}