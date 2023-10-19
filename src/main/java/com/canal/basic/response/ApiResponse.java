package com.canal.basic.response;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private Long code;
    private String message;
    private T data;

    private ApiResponse() {
    }

    private ApiResponse(Long code) {
        this.code = code;
    }

    private ApiResponse(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    private ApiResponse(Long code, T data) {
        this.code = code;
        this.data = data;
    }

    private ApiResponse(Long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(){
        return new ApiResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ApiResponse<T> success(String message){
        return new ApiResponse<T>(ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> ApiResponse<T> success(T data){
        return new ApiResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ApiResponse<T> success(String message, T data){
        return new ApiResponse<T>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ApiResponse<T> fail(Long code, String message){
        return new ApiResponse<T>(code, message);
    }

    public static <T> ApiResponse<T> fail(Long code, String message, T data){
        return new ApiResponse<T>(code, message, data);
    }
}
