package com.qht.service.impl;

import com.qht.dao.BookDao;
import com.qht.dao.OrderDao;
import com.qht.dao.OrderItemDao;
import com.qht.dao.impl.BookDaoImp;
import com.qht.dao.impl.OrderDaoImp;
import com.qht.dao.impl.OrderItemImp;
import com.qht.pojo.*;
import com.qht.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImp implements OrderService {
    private OrderDao orderDao = new OrderDaoImp();
    private OrderItemDao orderItemDao = new OrderItemImp();
    private BookDao bookDao = new BookDaoImp();
    //生成订单
    @Override
    public String creatOrder(Cart cart, Integer userId) {
        //订单号 唯一性
        String orderId = System.currentTimeMillis()+""+userId;
        //创建一个订单对象
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        //保存订单
        orderDao.saveOrder(order);

        int s = 12/0;

        //遍历购物车每一个商品转换成为订单项保存到数据库
        for(Map.Entry<Integer, CartItem> map : cart.getItems().entrySet()){
            CartItem value = map.getValue();
            OrderItme orderItme = new OrderItme(value.getId(), value.getName(), value.getCount(), value.getPrice(), value.getTotalPrice(), orderId);
            //减去库存 更新
            Book book = bookDao.queryBookId(value.getId());
            book.setSales(book.getSales()+value.getCount());
            book.setStock(book.getStock()-value.getCount());
            bookDao.updateBook(book);
            //保存订单项到数据库
            orderItemDao.saveOrderItem(orderItme);
        }
        //清空购物车
        cart.clear();


        return orderId;
    }

    //获取全部订单
    @Override
    public List<Order> getOrder() {
        List<Order> orders = orderDao.queryAllOrder();
        return orders;
    }

    //发货
    @Override
    public void updateStatus(String orderId) {
        orderDao.signFor(orderId);
    }

    @Override
    public List<OrderItme> getOrderItmelist(String orderId) {
        return orderItemDao.queryOrderItemlist(orderId);
    }

    @Override
    public List<Order> getOrderItmelistbyuserId(Integer userId) {
        return orderDao.queryUserOrder(userId);
    }

    @Override
    public Page<Order> pagination(int start, int size,int userId) {
        Page<Order> pageOrder = new Page<>();
        //设置每页显示的页码
        pageOrder.setPageSize(size);
        //设置总记录数
        Integer totalPage = orderDao.userOrderCount(userId);
        pageOrder.setPageTotalCount(totalPage);

        //计算 页码 设置页码总数
        int pages = totalPage/pageOrder.getPageSize();
        if(totalPage%pageOrder.getPageSize() != 0){
            pages++;
        }
        pageOrder.setPageTotal(pages);
        //设置当前页码
        pageOrder.setPageNo(start);

        //求当前页面数据开始的索引
        int begin = (pageOrder.getPageNo()-1)*size;

        List<Order> orders = orderDao.queryUserOrderpage(userId, begin, pageOrder.getPageSize());

        //设置当前页数据
        pageOrder.setItems(orders);


        return pageOrder;
    }


}
