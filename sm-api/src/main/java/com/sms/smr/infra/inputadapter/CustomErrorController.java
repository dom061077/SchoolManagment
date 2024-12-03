package com.sms.smr.infra.inputadapter;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

//@Controller
public class CustomErrorController implements ErrorController {

   /*  @RequestMapping("/error")
    public ResponseEntity<String> handleError(HttpServletRequest request) {
        // Custom logic to handle errors and return a consistent error response
        Exception e = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("An error occurred");
    }*/



}
