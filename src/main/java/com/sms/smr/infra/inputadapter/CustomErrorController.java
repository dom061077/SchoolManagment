package com.sms.smr.infra.inputadapter;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class CustomErrorController/* implements ErrorController */{

   // @RequestMapping("/error")
    public ResponseEntity<String> handleError() {
        // Custom logic to handle errors and return a consistent error response
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("An error occurred");
    }


}
