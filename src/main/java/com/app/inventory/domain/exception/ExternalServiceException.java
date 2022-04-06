package com.app.inventory.domain.exception;

/**
 * error in case of external service
 */
public class ExternalServiceException extends RuntimeException {

    ExternalServiceException(String message){
        super(message);
    }

    ExternalServiceException(String message, Throwable error){
        super(message, error);
    }
}