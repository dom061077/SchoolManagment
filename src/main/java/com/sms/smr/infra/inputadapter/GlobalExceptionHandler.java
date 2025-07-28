package com.sms.smr.infra.inputadapter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.smr.infra.exception.ApiException;
import com.sms.smr.infra.exception.InternalServerErrorException;
//NO ESTA FUNCIONANDO CORRECTAMENTE
@ControllerAdvice
public class GlobalExceptionHandler    {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    public ObjectMapper objectMapper = new ObjectMapper();

 
    private Map<String, Object> createErrorResponse(String message, Map<String, String> fieldErrors) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
        errorDetails.put("error", "Bad Request");
        errorDetails.put("message", message);
        errorDetails.put("errors",fieldErrors);
        return errorDetails;
    }

    private Map<String, Object> createErrorResponse(ApiException e){
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", e.getHttpStatus());
        errorDetails.put("error", e.getCode());
        errorDetails.put("message", e.getMessage());
        return errorDetails;    
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleNotSupportedMethod(MethodArgumentNotValidException ex) {
        logger.error("Not supported method", ex.getMessage());

        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            fieldErrors.put(error.getField(), error.getDefaultMessage())
        );
        Map<String, Object> errorDetails = createErrorResponse("Validation failed",fieldErrors);
        
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handleMissingParams(MissingServletRequestParameterException e) {
        logger.error("Missing request parameter", e);
         Map<String, String> fieldErrors = new HashMap<>();
        Map<String, Object> errorDetails = createErrorResponse("Missing request parameter: "+e.getParameterName(), fieldErrors);
       

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }    

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException e) {
        logger.error("Illegal argument", e);
        Map<String, String> fieldErrors = new HashMap<>();
        Map<String, Object> errorDetails = createErrorResponse(e.getMessage(), fieldErrors);
        
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFound(Exception e) {
        // Provide custom 404 error handling logic here
        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage()); // This should map to your custom not found page or endpoint
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleInternalServerErrorException(InternalServerErrorException e){
        return new ResponseEntity<>(createErrorResponse(e), HttpStatus.INTERNAL_SERVER_ERROR);
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
