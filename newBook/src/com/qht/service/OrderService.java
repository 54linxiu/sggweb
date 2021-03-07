package com.qht.service;

import com.qht.pojo.Cart;
import com.qht.pojo.Order;
import com.qht.pojo.OrderItme;
import com.qht.pojo.Page;

import java.util.List;

public interface OrderService {
    String creatOrder(Cart cart,Integer userId);
    List<Order> getOrder();
    void updateStatus(String orderId);

    List<OrderItme> getOrderItmelist(String orderId);
    List<Order> getOrderItmelistbyuserId(Integer userId);

    //分页
    Page<Order> pagination(int start, int size,int userId);
}
