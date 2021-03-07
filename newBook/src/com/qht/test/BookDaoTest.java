package com.qht.test;

import com.qht.dao.BookDao;
import com.qht.dao.impl.BookDaoImp;
import com.qht.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookDaoTest {


    BookDao bookDao = new BookDaoImp();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"最美code",new BigDecimal(9.9),"林修",1000,0,null));
    }

    @Test
    public void deleteBookId() {
        String sql = "delete from t_book where id = ?";
        bookDao.deleteBookId(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"最美code",new BigDecimal(9.9),"林修xiu",1000,0,null));
    }

    @Test
    public void queryBookId() {
        Book book = bookDao.queryBookId(21);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        books.forEach(book -> System.out.println(book));
    }

    @Test
    public void queryTotalCount(){
        System.out.println(bookDao.queryTotalCount());
    }
    @Test
    public void queryTotalCountby2(){
        System.out.println(bookDao.queryForPageTotalCount(20,50));
    }

    @Test
    public void queryForPageItems(){
        System.out.println(bookDao.queryForPageItems(20, 4));
    }
    @Test
    public void queryForPageItemsby2(){
        System.out.println(bookDao.queryForPageItems(0, 4,20,50));
    }


}