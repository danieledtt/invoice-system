package com.danieledtt.invoicesystem.bo.exception;

/**
 * Created by DuttoDa on 24/04/2018.
 */
public class ISBusinessExcetion extends Exception {

    private static final long serialVersionUID = 1L;

    public static final String BO_EXCEPTION_MESSAGE = "Business Internal Error.";

    public ISBusinessExcetion() {
        super();
    }

    public ISBusinessExcetion(String mex) {
        super(mex);
    }

    public ISBusinessExcetion(String mex, Throwable t) {
        super(mex, t);
    }

    public ISBusinessExcetion(Throwable t) {
        super(t);
    }
}
