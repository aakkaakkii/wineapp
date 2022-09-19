package com.wine.authservice.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super(String.format("User with Id - '%d' not found", id));
    }

    public UserNotFoundException(String name) {
        super(String.format("User with username/mail '%s' not found", name));
    }
}
