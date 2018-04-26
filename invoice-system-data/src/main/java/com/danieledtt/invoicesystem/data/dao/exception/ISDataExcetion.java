package com.danieledtt.invoicesystem.data.dao.exception;

/**
 * Created by DuttoDa on 24/04/2018.
 */
public class ISDataExcetion extends Exception {

    private static final long serialVersionUID = 1L;

    public static final String DATA_EXCEPTION_MESSAGE = "Data Internal Error.";

    public ISDataExcetion() {
        super();
    }

    public ISDataExcetion(String mex) {
        super(mex);
    }

    public ISDataExcetion(String mex, Throwable t) {
        super(mex, t);
    }

    public ISDataExcetion(Throwable t) {
        super(t);
    }
}
