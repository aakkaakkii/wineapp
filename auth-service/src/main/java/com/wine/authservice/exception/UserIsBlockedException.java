package com.wine.authservice.exception;

public class UserIsBlockedException extends RuntimeException {
    public UserIsBlockedException(String user){
        super(String.format("User with username '%s' is Blocked", user));
    }
}
