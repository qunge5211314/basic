package com.canal.basic.exception;

import com.canal.basic.response.ResponseCode;

public class DataConflictException extends ApiException {
    private final Long code = ResponseCode.CONFLICT.getCode();

    public DataConflictException(String message) {
        super(message);
    }

    @Override
    public Long getCode() {
        return code;
    }
}
