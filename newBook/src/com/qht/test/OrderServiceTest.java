package com.qht.test;

import com.qht.pojo.Order;
import com.qht.pojo.Page;
import com.qht.service.OrderService;
import com.qht.service.impl.OrderServiceImp;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void pagination() {
        OrderService o = new OrderServiceImp();
        Page<Order> pagination = o.pagination(0, 4, 5);
        System.out.println(pagination);
    }
}