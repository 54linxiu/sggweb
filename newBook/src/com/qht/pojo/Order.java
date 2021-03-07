package com.qht.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 */
public class Order {
    private String order_id;
    private Date create_time;
    private BigDecimal price;
    private Integer status;//状态 0未发货 1已发货 2 已签收
    private Integer user_id;

    public Order() {
    }

    public Order(String orderId, Date createTime, BigDecimal price, Integer status, Integer userId) {
        this.order_id = orderId;
        this.create_time = createTime;
        this.price = price;
        this.status = status;
        this.user_id = userId;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + order_id + '\'' +
                ", createTime=" + create_time +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + user_id +
                '}';
    }
}
