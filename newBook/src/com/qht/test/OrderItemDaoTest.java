package com.qht.test;

import com.qht.dao.OrderItemDao;
import com.qht.dao.impl.OrderItemImp;
import com.qht.pojo.Cart;
import com.qht.pojo.CartItem;
import com.qht.pojo.OrderItme;
import com.qht.service.OrderService;
import com.qht.service.impl.OrderServiceImp;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));
        OrderService orderService = new OrderServiceImp();
        String s = orderService.creatOrder(cart, 1);
        System.out.println("订单编号"+s);

    }

    @Test
    public void queryOne(){
        OrderItemDao itemDao = new OrderItemImp();
        List<OrderItme> orderItmes = itemDao.queryOrderItemlist("16135577918235");
        System.out.println(orderItmes);

    }


}