package com.qht.dao.impl;

import com.qht.dao.OrderDao;
import com.qht.pojo.Order;

import java.util.List;

public class OrderDaoImp extends BaseDAO  implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql, order.getOrder_id(),order.getCreate_time(),order.getPrice(),order.getStatus(),order.getUser_id());
    }

    @Override
    public Order queryOrder(Integer userId) {
        String sql = "SELECT `order_id`,`create_time`,`price`,`status`,`user_id` FROM t_order WHERE `user_id` = ?";
        return queryForOne(Order.class, sql, userId);
    }

    @Override
    public int signFor(String orderId) {
        String sql = "UPDATE t_order SET `status` = 1 WHERE `order_id` = ?";
        return update(sql, orderId);
    }

    @Override
    public List<Order> queryAllOrder() {
        String sql = "select * from t_order";
        return queryForList(Order.class, sql );
    }

    @Override
    public List<Order> queryUserOrder(Integer userId) {
        String sql = "select * from t_order where user_id = ?";

        return queryForList(Order.class, sql, userId);
    }

    @Override
    public List<Order> queryUserOrderpage(Integer userId,int start,int size) {
        String sql = "select * from `t_order` where user_id = ? limit ?,?";
        return queryForList(Order.class, sql, userId,start,size);
    }

    @Override
    public Integer userOrderCount(Integer userId) {
        String sql = "select count(*) from t_order where user_id = ?";
        return ((Number)queryForSingValue(sql, userId)).intValue();
    }
}
