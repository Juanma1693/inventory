package com.app.inventory.api.advice;

import com.app.inventory.api.model.response.ErrorBody;
import com.app.inventory.common.exception.ResourceNoContentException;
import com.app.inventory.common.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

/**
 * Check known errors and return HTTP response as appropriate
 */
@RestControllerAdvice
@Slf4j
public class ErrorControllerAdvice {
    /**
     * handle ResourceNotFoundException response
     * @param e ResourceNotFoundException
     * @return HTTP Status 404 (Not Found)
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handlerResourceNotFoundException(ResourceNotFoundException e) {

        return ResponseEntity.notFound().build();

    }

    /**
     * handle ResourceNoContentException response
     * @param e ResourceNoContentException
     * @return HTTP Status 204 (No Content)
     */
    @ExceptionHandler(ResourceNoContentException.class)
    public ResponseEntity handlerResourceNoContentException(ResourceNoContentException e) {

        return ResponseEntity.noContent().build();

    }

    /**
     * handle MethodArgumentNotValidException response
     * @param e MethodArgumentNotValidException
     * @return ErrorBody object With error detail and HTTP Status 400 (Bad Request)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorBody> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        return ResponseEntity.badRequest().body(ErrorBody.builder().message(getFieldError(e)).timestamp(LocalDateTime.now()).build());
    }

    /**
     * handle HttpMediaTypeNotSupportedException response
     * @param e HttpMediaTypeNotSupportedException
     * @return ErrorBody object With error detail and HTTP Status 400 (Bad Request)
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorBody> handlerHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e){

        return ResponseEntity.badRequest().body(ErrorBody.builder().message("Invalid Media type").timestamp(LocalDateTime.now()).build());
    }

    /**
     * handle HttpMessageNotReadableException response
     * @param e HttpMessageNotReadableException
     * @return ErrorBody object With error detail and HTTP Status 400 (Bad Request)
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorBody> handlerHttpMessageNotReadableException(HttpMessageNotReadableException e){
        return ResponseEntity.badRequest().body(ErrorBody.builder().message("error in body format or empty body").timestamp(LocalDateTime.now()).build());
    }

    /**
     * handle ResourceNoContentException response
     * @param e ResourceNoContentException
     * @return HTTP Status 204 (No Content)
     */
    private String getFieldError(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldErrors().stream().findFirst().get();
        return fieldError.getDefaultMessage();
    }

}
