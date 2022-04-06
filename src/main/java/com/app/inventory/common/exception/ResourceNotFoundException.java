package com.app.inventory.common.exception;

/**
 * error in case of not found
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
