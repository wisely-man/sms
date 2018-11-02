package com.demo.core.exception;

public class BusinessException extends Exception {


    public BusinessException(String code, String message){
        super();
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

}
