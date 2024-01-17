package com.pranavbale.user.service.exception;

public class ResourceNotFountException extends RuntimeException{

    public ResourceNotFountException( ) {
        super("Resource Not found Exception");
    }

    public ResourceNotFountException(String massage) {
        super(massage);
    }
}
