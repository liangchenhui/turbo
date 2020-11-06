package com.xiaoju.uemc.turbo.core.exception;


import com.xiaoju.uemc.turbo.core.common.ErrorEnum;

/**
 * Created by Stefanie on 2019/12/8.
 */
public class SuspendException extends ProcessException {

    public SuspendException(int errNo, String errMsg) {
        super(errNo, errMsg);
    }

    public SuspendException(ErrorEnum errorEnum) {
        super(errorEnum);
    }

    public SuspendException(ErrorEnum errorEnum, String detailMsg) {
        super(errorEnum, detailMsg);
    }
}