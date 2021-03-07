package com.qht.dao;

import com.qht.pojo.Book;

import java.util.List;

public interface BookDao {
    int addBook(Book book);

    int deleteBookId(Integer id);

    int updateBook(Book book);

    Book queryBookId(Integer id);

    List<Book> queryBooks();


    Integer queryTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    List<Book> queryForPageItems(int begin, int pageSize,int min,int max);

    Integer queryForPageTotalCount(int min, int max);
}
