package com.danieledtt.invoicesystem.bo.interf;

import com.danieledtt.invoicesystem.bo.exception.ISBusinessExcetion;
import com.danieledtt.invoicesystem.model.Invoice;
import com.danieledtt.invoicesystem.model.Order;
import org.slf4j.Logger;

/**
 * Created by DuttoDa on 24/04/2018.
 */
public interface InvoicePrinter {

    void printInvoice(Invoice invoice, Logger rootLogger) throws ISBusinessExcetion;
}
