package com.sms.smr.infra.inputadapter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("An internal server error occurred: " + ex.getMessage());
    }

    /*@ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Bad request: " + ex.getMessage());
    }*/

    // Add additional exception handlers for specific error types

}
