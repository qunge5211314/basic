package com.canal.basic.exception;

import com.canal.basic.response.ResponseCode;

public class DataNotFoundException extends ApiException{
    private final Long code = ResponseCode.NOT_FOUND.getCode();
    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(Long code, String message) {
        super(code, message);
    }

    @Override
    public Long getCode() {
        return code;
    }
}
