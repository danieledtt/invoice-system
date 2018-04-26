package com.danieledtt.invoicesystem.bo.impl;

import com.danieledtt.invoicesystem.bo.exception.ISBusinessExcetion;
import com.danieledtt.invoicesystem.bo.interf.InvoicePrinter;
import com.danieledtt.invoicesystem.model.Invoice;
import com.danieledtt.invoicesystem.model.InvoiceItem;
import com.danieledtt.invoicesystem.utils.StackTraceUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Created by DuttoDa on 24/04/2018.
 */
@Component
public class InvoicePrinterImpl implements InvoicePrinter {


    public void printInvoice(Invoice invoice, Logger rootLogger) throws ISBusinessExcetion {
        String serivce = "[InvoiceProcuderImpl][printInvoice]";
        long start = System.currentTimeMillis();
        try {
            rootLogger.debug(serivce + " - START [" + start + "]");
            if(invoice==null)
                throw new ISBusinessExcetion("invoice is null");

            if(invoice.getInvoiceItemList()==null)
                throw new ISBusinessExcetion("invoice items is null");

            rootLogger.info("###### INVOICE ["+invoice.getIdInvoice()+"] #####");
            for(InvoiceItem invoiceItem : invoice.getInvoiceItemList()){
                printInvoiceItem(invoiceItem,rootLogger);
            }

            rootLogger.info("Sales Taxes: "+invoice.getTotalTax());
            rootLogger.info("Total: "+invoice.getTotalCost());
            rootLogger.info("###### END INVOICE ["+invoice.getIdInvoice()+"] #####");

        } catch (Throwable t) {
            rootLogger.error(serivce + " - " + StackTraceUtils.getStackTrace(t));
            throw new ISBusinessExcetion(ISBusinessExcetion.BO_EXCEPTION_MESSAGE + " - [" + t.getMessage() + "]");
        } finally {
            long stop = System.currentTimeMillis();
            rootLogger.debug(serivce + " - STOP STOP ["+ stop +"] ElaborationTime[" + (stop - start) + " msec]");
        }
    }

    private void printInvoiceItem(InvoiceItem invoiceItem, Logger rootLogger) throws ISBusinessExcetion {
        String serivce = "[InvoiceProcuderImpl][printInvoiceItem]";
        long start = System.currentTimeMillis();
        try {
            rootLogger.debug(serivce + " - START [" + start + "]");
            if(invoiceItem==null)
                throw new ISBusinessExcetion("invoiceItem is null");

            if(invoiceItem.getOrderItem()==null)
                throw new ISBusinessExcetion("order item is null");

            if(invoiceItem.getOrderItem().getProduct()==null)
                throw new ISBusinessExcetion("product item is null");

            rootLogger.info(""+invoiceItem.getOrderItem().getQuantity()+" "+invoiceItem.getOrderItem().getProduct().getName()+": "+invoiceItem.getTotalCost());


        } catch (Throwable t) {
            rootLogger.error(serivce + " - " + StackTraceUtils.getStackTrace(t));
            throw new ISBusinessExcetion(ISBusinessExcetion.BO_EXCEPTION_MESSAGE + " - [" + t.getMessage() + "]");
        } finally {
            long stop = System.currentTimeMillis();
            rootLogger.debug(serivce + " - STOP STOP ["+ stop +"] ElaborationTime[" + (stop - start) + " msec]");
        }
    }
}
