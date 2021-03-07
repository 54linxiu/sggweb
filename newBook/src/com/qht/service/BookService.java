package com.qht.service;

import com.qht.pojo.Book;
import com.qht.pojo.Page;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    void deleteBook(Integer id);

    void updateBook(Book book);

    Book queryBook(Integer id);

    List<Book> queryBooks();


    Page<Book> page(int pageNo, int pageSize);


    Page<Book> pageByPrice(int begin, int Size, int min, int max);


}
