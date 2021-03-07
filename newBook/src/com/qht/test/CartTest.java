package com.qht.test;

import com.qht.pojo.Cart;
import com.qht.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(new Integer(1), "A计划", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(new Integer(1), "A计划", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(new Integer(2), "嘻嘻花花", 1, new BigDecimal(100), new BigDecimal(100)));

        System.out.println(cart);

    }

    @Test
    public void deleteItme() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(new Integer(1), "A计划", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(new Integer(1), "A计划", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(new Integer(2), "嘻嘻花花", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.deleteItme(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(new Integer(1), "A计划", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(new Integer(1), "A计划", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(new Integer(2), "嘻嘻花花", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(new Integer(1), "A计划", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(new Integer(1), "A计划", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(new Integer(2), "嘻嘻花花", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.updateCount(1, 5);
        System.out.println(cart);
    }
}