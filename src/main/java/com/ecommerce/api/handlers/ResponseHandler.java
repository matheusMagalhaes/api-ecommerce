package com.ecommerce.api.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ResponseHandler {

        public static ResponseEntity<Object> handlerResponse(String message, HttpStatusCode status, Object responseObj){
            Map<String, Object> responseMap = new HashMap<>();

            responseMap.put("message", message);
            responseMap.put("status", status.value());

            if(status == HttpStatus.OK){
            responseMap.put("data", responseObj);
            }else {
                responseMap.put("errors", responseObj);
            }
            return new ResponseEntity<>(responseMap, status);
        }
}
