package com.wine.userservice.api.error;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {super("Unauthorized");}

    public UnauthorizedException(String message) {
        super(message);
    }
}
