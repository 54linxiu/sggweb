package com.qht.thredlocal;

import com.qht.service.OrderService;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class Task implements Runnable{
    /**
     * ThreadLocal 的特点：
     * 1、ThreadLocal 可以为当前线程关联一个数据。（它可以像 Map 一样存取数据，key 为当前线程）
     * 2、每一个 ThreadLocal 对象，只能为当前线程关联一个数据，如果要为当前线程关联多个数据，就需要使用多个
     * ThreadLocal 对象实例。
     * 3、每个 ThreadLocal 对象实例定义的时候，一般都是 static 类型
     * 4、ThreadLocal 中保存数据，在线程销毁后。会由 JVM 虚拟自动释放。
     */
    public static Map<String,Object> data = new Hashtable<String,Object>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
    @Override
    public void run() {
        //生成数据 线程关联数据
        Integer i = new Random().nextInt(1000);//0-999
        //获取当前线程名
        String name = Thread.currentThread().getName();
        System.out.println(name+"的随机数是"+i);
        //关联
        threadLocal.set(i);//如果有多个值 可以多创建几个threadlocal
        data.put(name,i);

        try {
            Thread.sleep(3000); //等三秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new OrderService().createOrder();

        //即将结束 打印数据
        Object o = data.get(name);
        Object o1 = threadLocal.get();
        System.out.println(name+"即将结束map"+o);
        System.out.println(name+"即将结束"+o1);
    }

    public static void main(String[] args){
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }
}
