package com.ucv.electrix.exceptions;

public class EntityAlreadyExistsServiceException extends ServiceException {
    public EntityAlreadyExistsServiceException(String message) {
        super(message);
    }

    public EntityAlreadyExistsServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
