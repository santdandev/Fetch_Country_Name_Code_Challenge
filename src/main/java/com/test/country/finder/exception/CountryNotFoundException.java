package com.test.country.finder.exception;

public class CountryNotFoundException extends Exception {

    private String message;
    private int code;

    public CountryNotFoundException(String message){
        super(message);
        this.message=message;
        this.code=404;
    }
}
