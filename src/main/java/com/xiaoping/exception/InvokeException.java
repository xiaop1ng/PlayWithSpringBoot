package com.xiaoping.exception;

import com.xiaoping.pojo.Rs;

/**
 * 业务异常类，WebExceptionHandler 中会统一处理这个异常返回到接口
 */
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
