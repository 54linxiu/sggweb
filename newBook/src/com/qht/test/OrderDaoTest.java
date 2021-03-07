package com.qht.test;

import com.qht.dao.OrderDao;
import com.qht.dao.impl.OrderDaoImp;
import com.qht.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDaoTest {
    static OrderDao orderDao = new OrderDaoImp();

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImp();
        orderDao.saveOrder(new Order("1234567890", new Date(), new BigDecimal(100), 0, 1));
        orderDao.saveOrder(new Order("1234567891", new Date(), new BigDecimal(300), 0, 2));
        orderDao.saveOrder(new Order("1234567892", new Date(), new BigDecimal(400), 0, 1));

    }

    @Test
    public void queryOne(){
        Order order = orderDao.queryOrder(5);
        System.out.println(order);
    }

    @Test
    public void queryAll(){
        List<Order> orders = orderDao.queryAllOrder();
        System.out.println(orders);
    }

    @Test
    public void setOrderStatus(){
        int i = orderDao.signFor("16134768657955");
        System.out.println(i);
    }

    @Test
    public void getUserOrder(){
        List<Order> orders = orderDao.queryUserOrder(5);
        System.out.println(orders);
    }

    @Test
    public void fy(){
        System.out.println(orderDao.queryUserOrderpage(5, 0, 4));
    }

    @Test
    public void countOrder(){
        System.out.println(orderDao.userOrderCount(5));
    }
}