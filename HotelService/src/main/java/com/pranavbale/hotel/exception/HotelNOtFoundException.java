package com.pranavbale.hotel.exception;

public class HotelNOtFoundException extends RuntimeException{

    public  HotelNOtFoundException() {
        super("Hotel Not found with given value");
    }

    public HotelNOtFoundException(String massage) {
        super(massage);
    }
}
