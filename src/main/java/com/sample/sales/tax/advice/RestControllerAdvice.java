package com.sample.sales.tax.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sample.sales.tax.exception.CustomeException;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
    
    @ExceptionHandler
    public ResponseEntity exceptionHandler( CustomeException customeException){
        return new ResponseEntity<>(customeException.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
