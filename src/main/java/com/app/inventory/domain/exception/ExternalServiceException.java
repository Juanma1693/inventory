package com.app.inventory.domain.exception;

public class ExternalServiceException extends RuntimeException {

    ExternalServiceException(String message){
        super(message);
    }

    ExternalServiceException(String message, Throwable error){
        super(message, error);
    }
}