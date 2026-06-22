package com.sms.smr.infra.exception;

import java.util.Map;

public class InternalServerErrorException extends ApiException{

    public InternalServerErrorException(String message) {
        super(500, "INTERNAL_SERVER_ERROR", message);
    
    }

    public InternalServerErrorException(int httpStatus, String code, String message, Map<String, Object> details) {
        super(httpStatus, code, message, details);
    }

}
