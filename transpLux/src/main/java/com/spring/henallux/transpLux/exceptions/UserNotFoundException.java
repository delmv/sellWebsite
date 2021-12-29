package com.spring.henallux.transpLux.exceptions;

public class UserNotFoundException extends Exception {
    private String user;

    public UserNotFoundException(String user) {
        this.user = user;
    }

    @Override
    public String getMessage() {
        return "The user with the email : " + user + " has not been found in the database";
    }
}
