package com.danieledtt.invoicesystem.data.dao;

import com.danieledtt.invoicesystem.data.dao.exception.ISDataExcetion;
import com.danieledtt.invoicesystem.model.BaseData;
import com.danieledtt.invoicesystem.utils.StackTraceUtils;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;


/**
 * Created by DuttoDa on 25/04/2018.
 */
@Component
public class ISDataManagerFactory {

    private static ISDataManagerFactory isDataManagerFactory;


    @Value("${invoicesystem.dataFile}")
    String configFileUrl;

    public ISDataManagerFactory buildISDataManagerFactory(Logger rootLogger) throws ISDataExcetion {
        long start = System.currentTimeMillis();
        String serivce = "[ISDataManagerFactory][buildISDataManagerFactory]";
        if(isDataManagerFactory!=null) return isDataManagerFactory;
        isDataManagerFactory= new ISDataManagerFactory();
        Gson gson = new Gson();
        JsonReader reader = null;
        BaseData baseData;
        try {
            rootLogger.debug(serivce + " - START [" + start + "]");
            rootLogger.debug("LOAD CONF: "+configFileUrl);
            File file = new File(getClass().getClassLoader().getResource(configFileUrl).getFile());

            reader = new JsonReader(new FileReader(file));
            baseData = gson.fromJson(reader, BaseData.class);


        } catch (Throwable t) {
            rootLogger.error(serivce + " - " + StackTraceUtils.getStackTrace(t));
            throw new ISDataExcetion(ISDataExcetion.DATA_EXCEPTION_MESSAGE + " - [" + t.getMessage() + "]");
        } finally {
            long stop = System.currentTimeMillis();
            rootLogger.debug(serivce + " - STOP STOP ["+ stop +"] ElaborationTime[" + (stop - start) + " msec]");
        }


        isDataManagerFactory.setBaseData(baseData);
        return isDataManagerFactory;
    }

    private BaseData baseData;

    public BaseData getBaseData() {
        return baseData;
    }

    private void setBaseData(BaseData baseData) {
        this.baseData = baseData;
    }
}
