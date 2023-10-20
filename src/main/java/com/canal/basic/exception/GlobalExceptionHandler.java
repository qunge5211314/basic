package com.canal.basic.exception;

import com.canal.basic.response.ApiResponse;
import com.canal.basic.response.ResponseCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Value("${basic.response.message.noHandler}")
    private String noHandlerMessage;

    @Value("${basic.response.message.methodError}")
    private String methodErrorMessage;

    @Value("${basic.response.message.missParam}")
    private String missParamMessage;

    @Value("${basic.response.message.serverError}")
    private String serverErrorMessage;


    @ExceptionHandler(AuthCodeException.class)
    public ApiResponse authCodeExceptionHandler(AuthCodeException e) {
        return ApiResponse.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(DataConflictException.class)
    public ApiResponse authCodeExistExceptionHandler(DataConflictException e) {
        return ApiResponse.fail(e.getCode(), e.getMessage());
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public ApiResponse noHandlerFoundExceptionHandler(NoHandlerFoundException e) {
        return ApiResponse.fail(ResponseCode.NOT_FOUND.getCode(), noHandlerMessage);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ApiResponse httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        return ApiResponse.fail(ResponseCode.METHOD_ERROR.getCode(), methodErrorMessage);
    }

    @ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
    public ApiResponse unsatisfiedServletRequestParameterExceptionHandler(HttpRequestMethodNotSupportedException e) {
        return ApiResponse.fail(ResponseCode.PARAM_ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ApiResponse missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        return ApiResponse.fail(ResponseCode.PARAM_ERROR.getCode(), e.getParameterName() + missParamMessage);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse globalExceptionHandler(Exception e) {
        System.out.println(e.getMessage());
        System.out.println(e.getClass());
        return ApiResponse.fail(ResponseCode.SERVER_ERROR.getCode(), serverErrorMessage);
    }
}
