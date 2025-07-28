package com.sms.smr.infra.exception;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException {

    private final int httpStatus;
    private final String code;
    private final Map<String, Object> details;
    
    public ApiException(int httpStatus, String code, String message) {
        this(httpStatus, code, message, null);
    }    
    public ApiException(int httpStatus, String code, String message, Map<String, Object> details) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
        this.details = details != null ? details : new HashMap<>();
    }    
}
