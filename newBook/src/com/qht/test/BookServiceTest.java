package com.qht.test;

import com.qht.pojo.Book;
import com.qht.pojo.Page;
import com.qht.service.BookService;
import com.qht.service.impl.BookServiceImp;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceTest {

    private BookService bookService = new BookServiceImp();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"三下江南",new BigDecimal(999),"放学别走",99,0,null));
    }

    @Test
    public void deleteBook() {
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"四下江南",new BigDecimal(999),"放学别走",99,0,null));
    }

    @Test
    public void queryBook() {
        Book book = bookService.queryBook(45);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
    @Test
    public void queryBooks2() {
        Page<Book> books = bookService.pageByPrice(0,4,20,50);
        System.out.println(books);
    }


}