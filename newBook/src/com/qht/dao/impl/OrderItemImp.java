package com.qht.dao.impl;

import com.qht.dao.OrderItemDao;
import com.qht.pojo.OrderItme;

import java.util.List;

public class OrderItemImp extends BaseDAO implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItme orderItme) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql, orderItme.getName(),orderItme.getCount(),orderItme.getPrice(),orderItme.getTotal_price(),orderItme.getOrder_id());
    }
    //没用到
//    @Override
    /*public OrderItme queryOrderItem(String orderId) {
        String sql = "SELECT `id`,`name`,`count`,`price`,`total_price`,`order_id` FROM t_order_item where order_id = ?";
        return queryForOne(OrderItme.class, sql, orderId);
    }*/

    @Override
    public List<OrderItme> queryOrderItemlist(String orderId) {
        String sql = "SELECT `id`,`name`,`count`,`price`,`total_price`,`order_id` FROM t_order_item where order_id = ?";
        return queryForList(OrderItme.class, sql, orderId);
    }
}
