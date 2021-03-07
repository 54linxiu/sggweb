package com.qht.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            InputStream inPutStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inPutStream);
            //创建 数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库连接池中的连接
     * @return 返回null 获取连接失败
     */
    public static Connection getConnection() {
        /*Connection conn = null;

        try {
            conn = dataSource.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;*/
        Connection conn = conns.get();

        if(conn == null){
            try {
                conn = dataSource.getConnection();//从数据库连接池中获取连接
                conns.set(conn); // 保存到 ThreadLocal 对象中，供后面的 jdbc 操作使用
                conn.setAutoCommit(false); // 设置为手动管理事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        Connection conn = conns.get();
        if(conn != null){// 如果不等于 null，说明 之前使用过连接，操作过数据库
            try {
                conn.commit(); //提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                //自动提交事务打开
                try {
                    conn.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DbUtils.closeQuietly(conn);// 关闭连接，资源
            }
        }
        // 一定要执行 remove 操作，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection conn = conns.get();
        if(conn != null){// 如果不等于 null，说明 之前使用过连接，操作过数据库
            try {
                conn.rollback(); //提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                //自动提交事务打开
                try {
                    conn.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DbUtils.closeQuietly(conn);// 关闭连接，资源
            }
        }
        // 一定要执行 remove 操作，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 关闭连接
     * @param conn
     */
    /*public static void close(Connection conn){
        if(conn != null){
            DbUtils.closeQuietly(conn);
        }
    }*/
}
