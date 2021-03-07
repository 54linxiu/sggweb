package com.qht.dao;

import com.qht.pojo.Order;

import java.util.List;

public interface OrderDao {
    int saveOrder(Order order);
    Order queryOrder(Integer userId);
    int signFor(String orderId);
    List<Order> queryAllOrder();
    List<Order> queryUserOrder(Integer userId);

    //多加分页
    List<Order> queryUserOrderpage(Integer userId,int start,int size);

    Integer userOrderCount(Integer userId);
}
