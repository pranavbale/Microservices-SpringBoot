package com.pranavbale.rating.exception;

public class RatingNotFoundException extends RuntimeException{

    public RatingNotFoundException(){
        super("Rating not found with given value ");

    }

    public RatingNotFoundException(String msg) {
        super(msg);
    }
}
