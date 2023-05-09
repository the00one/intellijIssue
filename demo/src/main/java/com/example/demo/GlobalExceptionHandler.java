package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler
    public ProblemDetail methodNotAllowed(HttpRequestMethodNotSupportedException exc) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.METHOD_NOT_ALLOWED,
                                                exc.getMessage() + "! Supported methods: " + Arrays.toString(exc.getSupportedMethods()));
    }
}
