package com.danieledtt.invoicesystem.model;

import java.math.BigDecimal;

/**
 * Created by DuttoDa on 24/04/2018.
 */
public class OrderItem {

    private long idOrderItem;
    private Product product;
    private BigDecimal quantity;

    public long getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(long idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;

        OrderItem orderItem = (OrderItem) o;

        if (idOrderItem != orderItem.idOrderItem) return false;
        if (product != null ? !product.equals(orderItem.product) : orderItem.product != null) return false;
        return !(quantity != null ? !quantity.equals(orderItem.quantity) : orderItem.quantity != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (idOrderItem ^ (idOrderItem >>> 32));
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "idOrderItem=" + idOrderItem +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
