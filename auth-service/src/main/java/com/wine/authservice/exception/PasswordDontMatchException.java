package com.wine.authservice.exception;

public class PasswordDontMatchException extends RuntimeException {
    public PasswordDontMatchException(){
        super("Password don't Match");
    }
}