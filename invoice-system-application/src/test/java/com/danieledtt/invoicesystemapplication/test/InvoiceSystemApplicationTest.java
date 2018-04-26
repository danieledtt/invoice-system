package com.danieledtt.invoicesystemapplication.test;

import com.danieledtt.invoicesystem.model.Invoice;
import com.danieledtt.invoicesystem.model.Order;
import com.danieledtt.invoicesystemapplication.InvoiceSystem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
/**
 * Created by DuttoDa on 25/04/2018.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceSystemApplicationTest {

    @Autowired
    InvoiceSystem invoiceSystem;

    @Test
    public void order1() throws Exception {
        List<Long> productIdList;
        Order order;
        Invoice invoice;

        productIdList = new ArrayList<Long>();
        productIdList.add(new Long(1));
        productIdList.add(new Long(2));
        productIdList.add(new Long(3));
        order = invoiceSystem.buildOrder(productIdList);
        invoice = invoiceSystem.processOrder(order);
        assertThat(invoice.getInvoiceItemList().get(0).getTotalCost().doubleValue(), equalTo(12.49));
        assertThat(invoice.getInvoiceItemList().get(1).getTotalCost().doubleValue(), equalTo(16.49));
        assertThat(invoice.getInvoiceItemList().get(2).getTotalCost().doubleValue(), equalTo(0.85));
        assertThat(invoice.getTotalTax().doubleValue(), equalTo(1.50));
        assertThat(invoice.getTotalCost().doubleValue(), equalTo(29.83));

    }

    @Test
    public void order2() throws Exception {
        List<Long> productIdList;
        Order order;
        Invoice invoice;

        productIdList = new ArrayList<Long>();
        productIdList.add(new Long(4));
        productIdList.add(new Long(5));
        order = invoiceSystem.buildOrder(productIdList);
        invoice = invoiceSystem.processOrder(order);
        assertThat(invoice.getInvoiceItemList().get(0).getTotalCost().doubleValue(), equalTo(10.50));
        assertThat(invoice.getInvoiceItemList().get(1).getTotalCost().doubleValue(), equalTo(54.65));
        assertThat(invoice.getTotalTax().doubleValue(), equalTo(7.65));
        assertThat(invoice.getTotalCost().doubleValue(), equalTo(65.15));

    }

    @Test
    public void order3() throws Exception {
        List<Long> productIdList;
        Order order;
        Invoice invoice;

        productIdList = new ArrayList<Long>();
        productIdList.add(new Long(6));
        productIdList.add(new Long(7));
        productIdList.add(new Long(8));
        productIdList.add(new Long(9));
        order = invoiceSystem.buildOrder(productIdList);
        invoice = invoiceSystem.processOrder(order);
        assertThat(invoice.getInvoiceItemList().get(0).getTotalCost().doubleValue(), equalTo(32.19));
        assertThat(invoice.getInvoiceItemList().get(1).getTotalCost().doubleValue(), equalTo(20.89));
        assertThat(invoice.getInvoiceItemList().get(2).getTotalCost().doubleValue(), equalTo(9.75));
        assertThat(invoice.getInvoiceItemList().get(3).getTotalCost().doubleValue(), equalTo(11.85));
        assertThat(invoice.getTotalTax().doubleValue(), equalTo(6.7));
        assertThat(invoice.getTotalCost().doubleValue(), equalTo(74.68));

    }
}
