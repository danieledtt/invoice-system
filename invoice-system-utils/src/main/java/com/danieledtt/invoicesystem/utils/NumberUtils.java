package com.danieledtt.invoicesystem.utils;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by DuttoDa on 26/04/2018.
 */
@Component
public class NumberUtils {

    public BigDecimal roundUp(BigDecimal roundingIn, BigDecimal roundFactor, Logger rootLogger){
        BigDecimal roundedOut = null;

        double roundingInD = roundingIn.doubleValue();
        double roundFacotrD = roundFactor.doubleValue();
        double roundedInD =  Math.round(roundingInD * (1.0/roundFacotrD)) / (1.0/roundFacotrD);
        rootLogger.debug("roundingInD=" + roundedInD);
        if(roundedInD<roundingInD) {
            rootLogger.debug("correcting roundingInD");
            roundedInD = Math.round((roundingInD+roundFacotrD) * (1.0/roundFacotrD)) / (1.0/roundFacotrD);
        }
        rootLogger.debug("roundedInD=" + roundedInD);
        MathContext mathContext = new MathContext(2);
        roundedOut = new BigDecimal(roundedInD).round(mathContext);

        rootLogger.debug("roundedOut=" + roundedOut);

        return roundedOut;
    }
}
