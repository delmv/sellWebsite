package com.spring.henallux.transpLux.exceptions;

public class ErrorOccured extends Exception {
    private String message;

    public ErrorOccured(String message) {
        this.message = message;
    }
    @Override
    public String getMessage(){ return message;}

}
