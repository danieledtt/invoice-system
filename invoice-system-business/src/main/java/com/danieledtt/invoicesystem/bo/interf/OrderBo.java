package com.danieledtt.invoicesystem.bo.interf;

import com.danieledtt.invoicesystem.bo.exception.ISBusinessExcetion;
import com.danieledtt.invoicesystem.model.OrderItem;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by DuttoDa on 25/04/2018.
 */
public interface OrderBo {

    List<OrderItem> getOrderItemFromProductIdList(List<Long> productId, Logger rootLogger) throws ISBusinessExcetion;
}
