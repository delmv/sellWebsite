package com.spring.henallux.transpLux.exceptions;

public class EmptyProductListException extends Exception{
    @Override
    public String getMessage(){ return "The product list is empty";}
}
