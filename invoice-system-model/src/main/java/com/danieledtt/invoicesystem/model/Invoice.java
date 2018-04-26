package com.danieledtt.invoicesystem.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by DuttoDa on 24/04/2018.
 */
public class Invoice {

    private long idInvoice;
    private List<InvoiceItem> invoiceItemList;
    private BigDecimal totalCost;
    private BigDecimal totalTax;

    public long getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(long idInvoice) {
        this.idInvoice = idInvoice;
    }

    public List<InvoiceItem> getInvoiceItemList() {
        return invoiceItemList;
    }

    public void setInvoiceItemList(List<InvoiceItem> invoiceItemList) {
        this.invoiceItemList = invoiceItemList;
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
        if (!(o instanceof Invoice)) return false;

        Invoice invoice = (Invoice) o;

        if (idInvoice != invoice.idInvoice) return false;
        if (invoiceItemList != null ? !invoiceItemList.equals(invoice.invoiceItemList) : invoice.invoiceItemList != null)
            return false;
        if (totalCost != null ? !totalCost.equals(invoice.totalCost) : invoice.totalCost != null) return false;
        return !(totalTax != null ? !totalTax.equals(invoice.totalTax) : invoice.totalTax != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (idInvoice ^ (idInvoice >>> 32));
        result = 31 * result + (invoiceItemList != null ? invoiceItemList.hashCode() : 0);
        result = 31 * result + (totalCost != null ? totalCost.hashCode() : 0);
        result = 31 * result + (totalTax != null ? totalTax.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "idInvoice=" + idInvoice +
                ", invoiceItemList=" + invoiceItemList +
                ", totalCost=" + totalCost +
                ", totalTax=" + totalTax +
                '}';
    }
}
