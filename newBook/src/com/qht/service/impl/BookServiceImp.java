package com.qht.service.impl;

import com.qht.dao.BookDao;
import com.qht.dao.impl.BookDaoImp;
import com.qht.pojo.Book;
import com.qht.pojo.Page;
import com.qht.service.BookService;

import java.util.List;

public class BookServiceImp implements BookService {

    private BookDao bookDao = new BookDaoImp();

    @Override
    public void addBook(Book book) {
//        new Book(null,"三下江南",new BigDecimal(999),"放学别走",99,0,null)
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteBookId(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBook(Integer id) {
        return bookDao.queryBookId(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> pageBook = new Page<>();


        //设置每页显示的数量
        pageBook.setPageSize(pageSize);
        //求总记录数
        Integer countBook = bookDao.queryTotalCount();
        //设置总记录数
        pageBook.setPageTotalCount(countBook);
        //求页码
        Integer pageTotal = countBook/pageSize;
        //判断是否多一页
        if(countBook%pageSize>0){
            pageTotal++;
        }

        //设置总页码
        pageBook.setPageTotal(pageTotal);

        //设置当前页码
        pageBook.setPageNo(pageNo);

        //求当前页面数据开始的索引
        int begin =(pageBook.getPageNo()-1)*pageSize;

        List<Book> itemsbook =bookDao.queryForPageItems(begin,pageSize);

        //设置当前页面数据
        pageBook.setItems(itemsbook);


        return pageBook;
    }

    @Override
    public Page<Book> pageByPrice(int bigin, int Size, int min, int max) {
        Page<Book> pageBook = new Page<>();


        //设置每页显示的数量
        pageBook.setPageSize(Size);
        //求总记录数
        Integer countBook = bookDao.queryForPageTotalCount(min,max);
        //设置总记录数
        pageBook.setPageTotalCount(countBook);
        //求页码
        Integer pageTotal = countBook/Size;
        //判断是否多一页
        if(countBook%Size>0){
            pageTotal++;
        }

        //设置总页码
        pageBook.setPageTotal(pageTotal);

        //设置当前页码
        pageBook.setPageNo(bigin);

        //求当前页面数据开始的索引
        int begin =(pageBook.getPageNo()-1)*Size;

        List<Book> itemsbook =bookDao.queryForPageItems(begin,Size,min,max);

        //设置当前页面数据
        pageBook.setItems(itemsbook);


        return pageBook;
    }


}
