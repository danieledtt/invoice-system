package com.danieledtt.invoicesystemapplication;

import com.danieledtt.invoicesystem.bo.interf.InvoicePrinter;
import com.danieledtt.invoicesystem.bo.interf.InvoiceProducer;
import com.danieledtt.invoicesystem.bo.interf.OrderBo;
import com.danieledtt.invoicesystem.model.Invoice;
import com.danieledtt.invoicesystem.model.Order;
import com.danieledtt.invoicesystem.utils.StackTraceUtils;
import com.danieledtt.invoicesystemapplication.exception.InvoiceSystemExcetion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DuttoDa on 25/04/2018.
 */
@Component
public class InvoiceSystem {
    private static final Logger rootLogger = LoggerFactory.getLogger(InvoiceSystem.class);

    @Autowired
    InvoiceProducer invoiceProducer;

    @Autowired
    InvoicePrinter invoicePrinter;

    @Autowired
    OrderBo orderBo;

    public Invoice processOrder(Order order) throws InvoiceSystemExcetion {
        String serivce = "[InvoiceSystem][buildOrder]";
        long start = System.currentTimeMillis();
        Invoice invoice = null;
        try {
            rootLogger.debug(serivce + " - START [" + start + "]");
            if(order==null)
                throw new InvoiceSystemExcetion("order is null");

            invoice = invoiceProducer.processOrder(order,rootLogger);


        } catch (Throwable t) {
            rootLogger.error(serivce + " - " + StackTraceUtils.getStackTrace(t));
            throw new InvoiceSystemExcetion(InvoiceSystemExcetion.IS_EXCEPTION_MESSAGE + " - [" + t.getMessage() + "]");
        } finally {
            long stop = System.currentTimeMillis();
            rootLogger.debug(serivce + " - STOP STOP ["+ stop +"] ElaborationTime[" + (stop - start) + " msec]");
        }
        return invoice;

    }

    public void printInvoice(Invoice invoice) throws InvoiceSystemExcetion {
        String serivce = "[InvoiceSystem][buildOrder]";
        long start = System.currentTimeMillis();

        try {
            rootLogger.debug(serivce + " - START [" + start + "]");
            if(invoice==null)
                throw new InvoiceSystemExcetion("invoice is null");

            invoicePrinter.printInvoice(invoice,rootLogger);


        } catch (Throwable t) {
            rootLogger.error(serivce + " - " + StackTraceUtils.getStackTrace(t));
            throw new InvoiceSystemExcetion(InvoiceSystemExcetion.IS_EXCEPTION_MESSAGE + " - [" + t.getMessage() + "]");
        } finally {
            long stop = System.currentTimeMillis();
            rootLogger.debug(serivce + " - STOP STOP ["+ stop +"] ElaborationTime[" + (stop - start) + " msec]");
        }

    }

    public Order buildOrder(List<Long> productIdList ) throws InvoiceSystemExcetion {
        String serivce = "[InvoiceSystem][buildOrder]";
        long start = System.currentTimeMillis();
        Order order = null;
        try {
            rootLogger.debug(serivce + " - START [" + start + "]");
            if(productIdList==null)
                throw new InvoiceSystemExcetion("productId list is null");

            order = new Order();
            order.setOrderItemList(orderBo.getOrderItemFromProductIdList(productIdList, rootLogger));


        } catch (Throwable t) {
            rootLogger.error(serivce + " - " + StackTraceUtils.getStackTrace(t));
            throw new InvoiceSystemExcetion(InvoiceSystemExcetion.IS_EXCEPTION_MESSAGE + " - [" + t.getMessage() + "]");
        } finally {
            long stop = System.currentTimeMillis();
            rootLogger.debug(serivce + " - STOP STOP ["+ stop +"] ElaborationTime[" + (stop - start) + " msec]");
        }
        return order;
    }
}
