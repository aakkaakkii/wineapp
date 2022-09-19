package com.wine.authservice.exception;

public class UserIsNotActiveException extends RuntimeException {
    public UserIsNotActiveException(String user) {
        super(String.format("User with username '%s' is not active", user));
    }
}
