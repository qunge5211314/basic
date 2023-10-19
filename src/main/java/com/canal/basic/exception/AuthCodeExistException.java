package com.canal.basic.exception;

import com.canal.basic.response.ResponseCode;

public class AuthCodeExistException extends ApiException {
    private final Long code = ResponseCode.CONFLICT.getCode();

    public AuthCodeExistException(String message) {
        super(message);
    }

    @Override
    public Long getCode() {
        return code;
    }
}
