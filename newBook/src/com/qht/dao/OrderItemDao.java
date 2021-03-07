package com.qht.dao;

import com.qht.pojo.OrderItme;

import java.util.List;

public interface OrderItemDao {
    int saveOrderItem(OrderItme orderItme);
//    OrderItme queryOrderItem(String orderId);
    List<OrderItme> queryOrderItemlist(String orderId);
}
