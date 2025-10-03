package com.sms.smr.infra.inputadapter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.smr.infra.exception.ApiException;
import com.sms.smr.infra.exception.InternalServerErrorException;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler    {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    public ObjectMapper objectMapper = new ObjectMapper();

 
    private Map<String, Object> createErrorResponse(String message, int httpStatus, Map<String, String> fieldErrors) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", httpStatus);
        errorDetails.put("error", "Internal Server Error");
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
        Map<String, Object> errorDetails = createErrorResponse("Validation failed",HttpStatus.METHOD_NOT_ALLOWED.value(),fieldErrors);
        
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<Object> handleUnsupportedOperationException(UnsupportedOperationException e) {
        logger.error("Server error", e);
        Map<String, String> fieldErrors = new HashMap<>();
        Map<String, Object> errorDetails = createErrorResponse("Server error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), fieldErrors);
        
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleInternalAuthenticationServiceException(InternalAuthenticationServiceException e) {
        logger.error("Access denied error", e);
        Map<String, String> fieldErrors = new HashMap<>();
        Map<String, Object> errorDetails = createErrorResponse("Accessdenied error: " + e.getMessage(),HttpStatus.FORBIDDEN.value(), fieldErrors);
        
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<Object> handleTransactionSystemException(TransactionSystemException e){
        logger.error("TransactionSystemException", e);
        
        Throwable rootCause = e.getRootCause();
        if (rootCause instanceof ConstraintViolationException){
            logger.info("It's a ConstraintViolationException");
            Map<String, String> constraintErrors = new HashMap<>();
            ConstraintViolationException cve = (ConstraintViolationException) rootCause;
            cve.getConstraintViolations().forEach(constraint->constraintErrors.put(constraint.getMessage(), (constraint.getInvalidValue()!=null ? constraint.getInvalidValue().toString():"")    ));
            Map<String, Object> errorDetails = createErrorResponse("Transaction System Exception: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value(),constraintErrors);
            return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
            
        }


        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage()); 
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handleMissingParams(MissingServletRequestParameterException e) {
        logger.error("Missing request parameter", e);
        Map<String, String> fieldErrors = new HashMap<>();
        Map<String, Object> errorDetails = createErrorResponse("Missing request parameter: "+e.getParameterName(),HttpStatus.BAD_REQUEST.value(), fieldErrors);
        

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }    

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException e) {
        logger.error("Illegal argument", e);
        Map<String, String> fieldErrors = new HashMap<>();
        Map<String, Object> errorDetails = createErrorResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value(), fieldErrors);
        
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNotFound(Exception e) {
        // Provide custom 404 error handling logic here
        logger.error("Exception",e);
        Map<String, String> fieldErrors = new HashMap<>();
        Map<String, Object> errorDetails = createErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), fieldErrors);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleInternalServerErrorException(InternalServerErrorException e){
        return new ResponseEntity<>(createErrorResponse(e), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidBearerTokenException.class)
    public ResponseEntity<String> handleInvalidBearerTokenException(InvalidBearerTokenException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("El token es incorrecto");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        Map<String, String> fieldErrors = new HashMap<>();
        Map<String, Object> errorDetails = createErrorResponse(e.getMessage(),HttpStatus.BAD_REQUEST.value(), fieldErrors);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<Object> handleInvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException e){
        Map<String, String> fieldErrors = new HashMap<>();
        Map<String, Object> errorDetails = createErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), fieldErrors);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    

    /*@ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Bad request: " + ex.getMessage());
    }*/

    // Add additional exception handlers for specific error types

}
