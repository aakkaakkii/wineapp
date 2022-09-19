package com.wine.authservice.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String username) {
        super(String.format("User with username '%s' already exists", username));
    }
}
