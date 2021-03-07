package com.qht.service;

import com.qht.thredlocal.Task;

public class OrderService {
    public void createOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("orderService 当前线程"+name+"保存的数值是 threadlocal"+ Task.threadLocal.get());
        System.out.println("orderService 当前线程"+name+"保存的数值是 map"+ Task.data.get(name));
    }
}
