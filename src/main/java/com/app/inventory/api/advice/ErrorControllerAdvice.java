package com.app.inventory.api.advice;

import com.app.inventory.api.model.response.ErrorBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ErrorControllerAdvice {

    /**
     * handle bean exception Validation Framework (hibernate)
     * @param e Exception handler
     * @return  ResponseEntity error message, detail, timestamp and status BAD_REQUEST
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorBody> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){

        HashMap<String, String> errors = e.getBindingResult().getAllErrors().stream()
                .map(err -> (FieldError) err)
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (e1, e2) -> e1, LinkedHashMap::new));

        return new ResponseEntity<>(
                ErrorBody.builder().message("error validating argument in web context")
                        .detailMessage(errors.toString())
                        .timestamp(LocalDateTime.now()).build()
                        ,
                HttpStatus.BAD_REQUEST
                );
    }
}
