package com.qht.dao.impl;

import com.qht.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO {

    //使用utils操作数据库
    private QueryRunner qr = new QueryRunner();

    /**
     * @param sql
     * @param args
     * @return 如果返回-1执行失败 其他表示执行影响的行数
     */
    public int update(String sql, Object... args) {
        System.out.println(" BaseDao 程序在[" +Thread.currentThread().getName() + "]中");
        Connection conn = JDBCUtils.getConnection();
        try {
            return qr.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回一个javaBean是sql语句
     *
     * @param type 返回参数的类型
     * @param sql  sql语句
     * @param args sql对应的参数
     * @param <T>  返回类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();

        try {
            return qr.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回多个javaBean是sql语句
     *
     * @param type 返回参数的类型
     * @param sql  sql语句
     * @param args sql对应的参数
     * @param <T>  返回类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();

        try {
            return qr.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * 执行一行一列的sql语句
     * @param sql 执行sql语句
     * @param args sql的参数
     * @return
     */
    public Object queryForSingValue(String sql,Object ... args){
        Connection conn = JDBCUtils.getConnection();

        try {
            return qr.query(conn, sql,  new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
