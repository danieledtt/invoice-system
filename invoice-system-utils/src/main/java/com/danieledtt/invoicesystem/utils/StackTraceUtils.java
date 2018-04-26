package com.danieledtt.invoicesystem.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by DuttoDa on 25/04/2018.
 */
public class StackTraceUtils {

    /**
     * This method takes a exception as an input argument and returns the stacktrace as a string.
     */
    public static String getStackTrace(Throwable exception) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        return sw.toString();
    }
}
