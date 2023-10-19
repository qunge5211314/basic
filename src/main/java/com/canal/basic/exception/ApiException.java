package com.canal.basic.exception;

public class ApiException extends RuntimeException {
    private Long code;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Long code, String message) {
        super(message);
        this.code = code;
    }

    public Long getCode() {
        return code;
    }

}
