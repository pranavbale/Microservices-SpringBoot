package com.pranavbale.hotel.exception;

import com.pranavbale.hotel.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HotelNOtFoundException.class)
    public ResponseEntity<ApiResponse> globalExceptionHandler(HotelNOtFoundException ex) {
        ApiResponse apiResponse = ApiResponse.builder()
                .massage(ex.getMessage())
                .code(HttpStatus.NOT_FOUND)
                .success(false)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }


}
