package com.ust.student.Exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String exceptionMessage){
        super(exceptionMessage);
    }
}
