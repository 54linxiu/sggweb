package com.qht.dao.impl;

import com.qht.dao.BookDao;
import com.qht.pojo.Book;

import java.util.List;

public class BookDaoImp extends BaseDAO implements BookDao {
    @Override
    public int addBook(Book book) {
//        new Book(null,"最美code",new BigDecimal(9.9),"林修",1000,0,null)
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookId(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookId(Integer id) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`" +
                "from t_book where id = ?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`" +
                "from t_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public Integer queryTotalCount() {
        String sql = "select count(*) from t_book";
        return ((Number)queryForSingValue(sql)).intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`  from t_book limit ?,?";
        return queryForList(Book.class, sql, begin,pageSize);
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize, int min, int max) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`  from t_book where price between ? and ? ORDER BY price ASC limit ?,?";
        return queryForList(Book.class, sql, min,max,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCount(int min, int max) {
        String sql = "SELECT COUNT(*) FROM t_book WHERE price BETWEEN ? AND ?";

        return ((Number)queryForSingValue(sql, min,max)).intValue();
    }
}
