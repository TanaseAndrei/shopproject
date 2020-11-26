package com.ucv.electrix.exceptions.services;

public class EntityNotFoundServiceException extends ServiceException{
    public EntityNotFoundServiceException(String message) {
        super(message);
    }

    public EntityNotFoundServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
