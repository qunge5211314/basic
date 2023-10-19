package com.canal.basic.exception;

import com.canal.basic.response.ResponseCode;

public class ExistUserException extends ApiException {
    final private Long code = ResponseCode.CONFLICT.getCode();

    public ExistUserException(String message) {
        super(message);
    }

    public Long getCode() {
        return code;
    }
}
