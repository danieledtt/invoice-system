package com.danieledtt.invoicesystem.data.dao.impl;

import com.danieledtt.invoicesystem.data.dao.ISDataManagerFactory;
import com.danieledtt.invoicesystem.data.dao.exception.ISDataExcetion;
import com.danieledtt.invoicesystem.data.dao.interf.ProductDao;
import com.danieledtt.invoicesystem.model.Product;
import com.danieledtt.invoicesystem.utils.StackTraceUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DuttoDa on 25/04/2018.
 */
@Component("ProductDao")
public class ProductDaoImpl implements ProductDao{

    @Autowired
    ISDataManagerFactory isDataManagerFactory;

    public Product findById(long idProduct, Logger rootLogger) throws ISDataExcetion {
        String serivce = "[ProductDaoImpl][findById]";
        long start = System.currentTimeMillis();
        Product product=null;
        try {
            rootLogger.debug(serivce + " - START [" + start + "]");

            List<Product> productList= isDataManagerFactory.buildISDataManagerFactory(rootLogger).getBaseData().getProductList();

            for(Product productDb : productList){
               if(productDb.getIdProduct()==idProduct){
                   product= productDb;
                   break;
               }
            }
            if(product==null)
                throw new ISDataExcetion("No product found for idProduct "+idProduct);
        } catch (Throwable t) {
            rootLogger.error(serivce + " - " + StackTraceUtils.getStackTrace(t));
            throw new ISDataExcetion(ISDataExcetion.DATA_EXCEPTION_MESSAGE + " - [" + t.getMessage() + "]");
        } finally {
            long stop = System.currentTimeMillis();
            rootLogger.debug(serivce + " - STOP STOP ["+ stop +"] ElaborationTime[" + (stop - start) + " msec]");
        }
        return product;
    }
}
