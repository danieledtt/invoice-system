package com.danieledtt.invoicesystemapplication;



import com.danieledtt.invoicesystem.model.Invoice;
import com.danieledtt.invoicesystem.model.Order;
import com.danieledtt.invoicesystem.model.OrderItem;
import com.danieledtt.invoicesystem.model.Product;
import com.danieledtt.invoicesystemapplication.exception.InvoiceSystemExcetion;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DuttoDa on 25/04/2018.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = "com.danieledtt.invoicesystemapplication," +
        "com.danieledtt.invoicesystem" )
public class InvoiceSystemApplication{

    public static void main(String[] args) throws InvoiceSystemExcetion {
        ApplicationContext ctx = SpringApplication.run(InvoiceSystemApplication.class, args);

        InvoiceSystem invoiceSystem = ctx.getBean(InvoiceSystem.class);

        List<Long> productIdList;
        Order order;
        Invoice invoice;

        productIdList = new ArrayList<Long>();
        productIdList.add(new Long(1));
        productIdList.add(new Long(2));
        productIdList.add(new Long(3));
        order = invoiceSystem.buildOrder(productIdList);
        invoice = invoiceSystem.processOrder(order);
        invoiceSystem.printInvoice(invoice);

        productIdList = new ArrayList<Long>();
        productIdList.add(new Long(4));
        productIdList.add(new Long(5));
        order = invoiceSystem.buildOrder(productIdList);
        invoice = invoiceSystem.processOrder(order);
        invoiceSystem.printInvoice(invoice);

        productIdList = new ArrayList<Long>();
        productIdList.add(new Long(6));
        productIdList.add(new Long(7));
        productIdList.add(new Long(8));
        productIdList.add(new Long(9));
        order = invoiceSystem.buildOrder(productIdList);
        invoice = invoiceSystem.processOrder(order);
        invoiceSystem.printInvoice(invoice);
    }


}
