package com.danieledtt.invoicesystem.data.dao.interf;

import com.danieledtt.invoicesystem.data.dao.exception.ISDataExcetion;
import com.danieledtt.invoicesystem.model.Product;
import org.slf4j.Logger;

import java.math.BigDecimal;

/**
 * Created by DuttoDa on 25/04/2018.
 */
public interface ProductDao {

    Product findById(long idProduct,Logger rootLogger) throws ISDataExcetion;
}
