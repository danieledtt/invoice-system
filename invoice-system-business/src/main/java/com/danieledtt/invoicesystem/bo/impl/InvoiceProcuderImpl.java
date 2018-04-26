package com.danieledtt.invoicesystem.bo.impl;

import com.danieledtt.invoicesystem.bo.exception.ISBusinessExcetion;
import com.danieledtt.invoicesystem.bo.interf.InvoiceProducer;
import com.danieledtt.invoicesystem.constant.InvoiceSystemConstant;
import com.danieledtt.invoicesystem.model.Invoice;
import com.danieledtt.invoicesystem.model.InvoiceItem;
import com.danieledtt.invoicesystem.model.Order;
import com.danieledtt.invoicesystem.model.OrderItem;
import com.danieledtt.invoicesystem.utils.NumberUtils;
import com.danieledtt.invoicesystem.utils.StackTraceUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DuttoDa on 24/04/2018.
 */
@Component("InvoiceProducer")
public class InvoiceProcuderImpl implements InvoiceProducer {

    @Autowired
    NumberUtils numberUtils;

    public Invoice processOrder(Order order, Logger rootLogger) throws ISBusinessExcetion {
        String serivce = "[InvoiceProcuderImpl][processOrder]";
        long start = System.currentTimeMillis();
        Invoice invoice = new Invoice();
        try {
            rootLogger.debug(serivce + " - START [" + start + "]");
            if(order==null)
                throw new ISBusinessExcetion("Order is null");

            if(order.getOrderItemList()==null)
                throw new ISBusinessExcetion("OrderItem is null");

            List<InvoiceItem> invoiceItemList = new ArrayList<InvoiceItem>();
            BigDecimal totalCost = new BigDecimal(0);
            BigDecimal totalTax = new BigDecimal(0);
            InvoiceItem invoiceItem = null;
            for(OrderItem orderItem : order.getOrderItemList()){
                invoiceItem = processOrderItem(orderItem,rootLogger);
                invoiceItemList.add(invoiceItem);
                totalCost=totalCost.add(invoiceItem.getTotalCost());
                totalTax=totalTax.add(invoiceItem.getTotalTax());
            }

            invoice.setIdInvoice(System.currentTimeMillis());
            invoice.setInvoiceItemList(invoiceItemList);
            invoice.setTotalCost(totalCost);
            invoice.setTotalTax(totalTax);

        } catch (Throwable t) {
            rootLogger.error(serivce + " - " + StackTraceUtils.getStackTrace(t));
            throw new ISBusinessExcetion(ISBusinessExcetion.BO_EXCEPTION_MESSAGE + " - [" + t.getMessage() + "]");
        } finally {
            long stop = System.currentTimeMillis();
            rootLogger.debug(serivce + " - STOP STOP ["+ stop +"] ElaborationTime[" + (stop - start) + " msec]");
        }
        return invoice;
    }

    private InvoiceItem processOrderItem(OrderItem orderItem, Logger rootLogger) throws ISBusinessExcetion {
        String serivce = "[InvoiceProcuderImpl][processOrderItem]";
        long start = System.currentTimeMillis();
        InvoiceItem invoiceItem = new InvoiceItem();
        try {
            rootLogger.debug(serivce + " - START [" + start + "]");
            if(orderItem==null)
                throw new ISBusinessExcetion("orderItem is null");

            if(orderItem.getProduct()==null)
                throw new ISBusinessExcetion("Produce is null");



            BigDecimal singleItemTax = orderItem.getProduct().getCategory().getTaxRate();

            if(orderItem.getProduct().getImported()){
                singleItemTax=singleItemTax.add(InvoiceSystemConstant.IMPORTED_TAXT);
            }
            BigDecimal localTax = orderItem.getQuantity().multiply(orderItem.getProduct().getNetPrice().multiply(singleItemTax));

            BigDecimal localRoundedTax=numberUtils.roundUp(localTax,InvoiceSystemConstant.ROUND_FACTOR,rootLogger);
            invoiceItem.setOrderItem(orderItem);

            invoiceItem.setTotalCost((orderItem.getQuantity().multiply(orderItem.getProduct().getNetPrice()).add(localRoundedTax)));
            invoiceItem.setTotalTax(localRoundedTax);

        } catch (Throwable t) {
            rootLogger.error(serivce + " - " + StackTraceUtils.getStackTrace(t));
            throw new ISBusinessExcetion(ISBusinessExcetion.BO_EXCEPTION_MESSAGE + " - [" + t.getMessage() + "]");
        } finally {
            long stop = System.currentTimeMillis();
            rootLogger.debug(serivce + " - STOP STOP ["+ stop +"] ElaborationTime[" + (stop - start) + " msec]");
        }
        return invoiceItem;

    }


}
