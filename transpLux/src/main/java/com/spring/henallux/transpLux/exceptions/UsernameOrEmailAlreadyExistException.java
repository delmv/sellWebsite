package com.spring.henallux.transpLux.exceptions;

public class UsernameOrEmailAlreadyExistException extends Exception{
    @Override
    public String getMessage(){ return "This username or this email address is already used";}
}
