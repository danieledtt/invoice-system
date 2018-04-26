package com.danieledtt.invoicesystem.model;

import java.math.BigDecimal;

/**
 * Created by DuttoDa on 24/04/2018.
 */
public class InvoiceItem {

    private long idInvoiceItem;
    private OrderItem orderItem;
    private BigDecimal totalCost;
    private BigDecimal totalTax;

    public long getIdInvoiceItem() {
        return idInvoiceItem;
    }

    public void setIdInvoiceItem(long idInvoiceItem) {
        this.idInvoiceItem = idInvoiceItem;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceItem)) return false;

        InvoiceItem that = (InvoiceItem) o;

        if (idInvoiceItem != that.idInvoiceItem) return false;
        if (orderItem != null ? !orderItem.equals(that.orderItem) : that.orderItem != null) return false;
        if (totalCost != null ? !totalCost.equals(that.totalCost) : that.totalCost != null) return false;
        return !(totalTax != null ? !totalTax.equals(that.totalTax) : that.totalTax != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (idInvoiceItem ^ (idInvoiceItem >>> 32));
        result = 31 * result + (orderItem != null ? orderItem.hashCode() : 0);
        result = 31 * result + (totalCost != null ? totalCost.hashCode() : 0);
        result = 31 * result + (totalTax != null ? totalTax.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InvoiceItem{" +
                "idInvoiceItem=" + idInvoiceItem +
                ", orderItem=" + orderItem +
                ", totalCost=" + totalCost +
                ", totalTax=" + totalTax +
                '}';
    }
}
