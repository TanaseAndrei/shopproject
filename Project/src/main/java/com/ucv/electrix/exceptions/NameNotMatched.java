package com.ucv.electrix.exceptions;

public class NameNotMatched extends RuntimeException{
    public NameNotMatched(String message){
        super(message);
    }

    public NameNotMatched(String message, Throwable throwable){
        super(message, throwable);
    }
}
