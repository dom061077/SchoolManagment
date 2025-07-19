package com.sms.smr.infra.inputadapter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
//NO ESTA FUNCIONANDO CORRECTAMENTE
@ControllerAdvice
public class GlobalExceptionHandler    {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    public ObjectMapper objectMapper = new ObjectMapper();

    /* 
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
    */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleNotSupportedMethod(MethodArgumentNotValidException ex) {
        logger.error("Not supported method", ex.getMessage());
        Map<String, Object> errorDetails = new HashMap<>();
        Map<String, String> fieldErrors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
            fieldErrors.put(error.getField(), error.getDefaultMessage())
        );

        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
        errorDetails.put("error", "Bad Request");
        errorDetails.put("message", "Validation failed");
        errorDetails.put("errors", fieldErrors);

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFound(Exception e) {
        // Provide custom 404 error handling logic here
        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage()); // This should map to your custom not found page or endpoint
    }

    @ExceptionHandler(InvalidBearerTokenException.class)
    public ResponseEntity<String> handleException(InvalidBearerTokenException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("El token es incorrecto");
    }

    /*@ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Bad request: " + ex.getMessage());
    }*/

    // Add additional exception handlers for specific error types

}
