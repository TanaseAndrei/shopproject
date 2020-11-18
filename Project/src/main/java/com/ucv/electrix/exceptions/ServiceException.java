package com.ucv.electrix.exceptions;

public class ServiceException extends RuntimeException{

    public ServiceException(String message, Throwable throwable){
        super(message, throwable);
    }

    public ServiceException(String message){
        super(message);
    }

}
