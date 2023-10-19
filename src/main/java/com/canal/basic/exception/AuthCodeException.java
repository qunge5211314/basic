package com.canal.basic.exception;

import com.canal.basic.response.ResponseCode;

public class AuthCodeException extends ApiException {
    final private Long code = ResponseCode.PARAM_ERROR.getCode();

    public AuthCodeException(String message) {
        super(message);
    }

    public Long getCode() {
        return code;
    }
}
