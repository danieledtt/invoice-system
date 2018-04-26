package com.danieledtt.invoicesystemapplication.exception;

/**
 * Created by DuttoDa on 24/04/2018.
 */
public class InvoiceSystemExcetion extends Exception {

    private static final long serialVersionUID = 1L;

    public static final String IS_EXCEPTION_MESSAGE = "Invoice System Error.";

    public InvoiceSystemExcetion() {
        super();
    }

    public InvoiceSystemExcetion(String mex) {
        super(mex);
    }

    public InvoiceSystemExcetion(String mex, Throwable t) {
        super(mex, t);
    }

    public InvoiceSystemExcetion(Throwable t) {
        super(t);
    }
}
