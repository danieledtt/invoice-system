package com.danieledtt.invoicesystem.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by DuttoDa on 24/04/2018.
 */
public class Order {

    private long idOrder;
    private List<OrderItem> orderItemList;

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (idOrder != order.idOrder) return false;
        return !(orderItemList != null ? !orderItemList.equals(order.orderItemList) : order.orderItemList != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (idOrder ^ (idOrder >>> 32));
        result = 31 * result + (orderItemList != null ? orderItemList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", orderItemList=" + orderItemList +
                '}';
    }
}
