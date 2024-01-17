package com.pranavbale.user.service.exception;

import com.pranavbale.user.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFountException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFountException ex) {

        String message = ex.getMessage();

        ApiResponse response =
                ApiResponse.builder()
                        .massage(message)
                        .success(true)
                        .code(HttpStatus.NOT_FOUND)
                        .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
   }
}
