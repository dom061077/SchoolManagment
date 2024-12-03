package com.sms.smr.infra.inputadapter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.firewall.RequestRejectedException;

import io.jsonwebtoken.ExpiredJwtException;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import java.util.NoSuchElementException;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//NO ESTA FUNCIONANDO CORRECTAMENTE
@ControllerAdvice
public class GlobalExceptionHandler    {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<String> handleException(Exception ex) {
       String bodyOfResponse = "Access denied: " + ex.getMessage();
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.FORBIDDEN);

    }
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleException() {
        return new ResponseEntity<>("Credenciales incorrectas",HttpStatus.UNAUTHORIZED);
    }    

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleException(NoSuchElementException e){
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(RequestRejectedException.class)
    public ResponseEntity<String> handleException(RequestRejectedException e) {
        logger.trace("RequestRejectedException", e);
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(
                        e.getMessage()
                );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFound(Exception e) {
        // Provide custom 404 error handling logic here
        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage()); // This should map to your custom not found page or endpoint
    }
    /*@ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Bad request: " + ex.getMessage());
    }*/

    // Add additional exception handlers for specific error types

}
