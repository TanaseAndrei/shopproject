package com.ucv.electrix.exceptions.services;

public class ImageCreationException extends ServiceException {
    public ImageCreationException(String message) {
        super(message);
    }

    public ImageCreationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
