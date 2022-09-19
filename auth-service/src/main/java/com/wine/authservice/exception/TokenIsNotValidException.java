package com.wine.authservice.exception;

public class TokenIsNotValidException extends RuntimeException {
    public TokenIsNotValidException() {
        super("Token is not valid");
    }
}
