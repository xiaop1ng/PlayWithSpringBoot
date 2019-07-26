package com.xiaoping.exception;

import com.xiaoping.pojo.Rs;

public class InvokeException extends RuntimeException {

    private int err;

    public int getErr(){
        return err;
    }

    public InvokeException(String msg) {
        super(msg);
        this.err = Rs.ERROR_CODE_BIZ;
    }

    public InvokeException(int err, String msg) {
        super(msg);
        this.err = err;
    }

}
