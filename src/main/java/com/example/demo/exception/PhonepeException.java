package com.example.demo.exception;

public class PhonepeException extends RuntimeException{

    public PhonepeException(String message, Throwable cause){
        super(message,cause);
    }
    public PhonepeException(String message){
        super(message);
    }

}
