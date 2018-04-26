package com.danieledtt.invoicesystem.bo.impl;

import com.danieledtt.invoicesystem.bo.exception.ISBusinessExcetion;
import com.danieledtt.invoicesystem.bo.interf.OrderBo;
import com.danieledtt.invoicesystem.data.dao.interf.ProductDao;
import com.danieledtt.invoicesystem.model.OrderItem;
import com.danieledtt.invoicesystem.utils.StackTraceUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DuttoDa on 25/04/2018.
 */
@Component("OrderBo")
public class OrderBoImpl implements OrderBo{

    @Autowired
    ProductDao productDao;

    public List<OrderItem> getOrderItemFromProductIdList(List<Long> productIdList, Logger rootLogger) throws ISBusinessExcetion {
        String serivce = "[OrderBoImpl][getOrderItemFromProductIdList]";
        long start = System.currentTimeMillis();
        List<OrderItem> orderItems= new ArrayList<OrderItem>();
        try {
            rootLogger.debug(serivce + " - START [" + start + "]");
            if(productIdList==null)
                throw new ISBusinessExcetion("productId list is null");

            OrderItem orderItem=null;
            for(Long productId : productIdList){
                orderItem = new OrderItem();
                orderItem.setQuantity(new BigDecimal(1));
                orderItem.setProduct(productDao.findById(productId.longValue(),rootLogger));
                orderItems.add(orderItem);
            }


        } catch (Throwable t) {
            rootLogger.error(serivce + " - " + StackTraceUtils.getStackTrace(t));
            throw new ISBusinessExcetion(ISBusinessExcetion.BO_EXCEPTION_MESSAGE + " - [" + t.getMessage() + "]");
        } finally {
            long stop = System.currentTimeMillis();
            rootLogger.debug(serivce + " - STOP STOP [" + stop + "] ElaborationTime[" + (stop - start) + " msec]");
        }
        return orderItems;
    }
}
