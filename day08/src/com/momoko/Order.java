package com.momoko;

/**
 * Created by momoko on 2021/1/13.
 */
public class Order<T> {

    String orderName;
    int orderId;

    T orderT;

    public Order() {}

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }
}