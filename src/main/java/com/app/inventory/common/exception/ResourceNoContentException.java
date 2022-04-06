package com.app.inventory.common.exception;

/**
 * error in case of no content
 */
public class ResourceNoContentException extends RuntimeException {
    public ResourceNoContentException(String message){
        super(message);
    }
}
