package com.wine.authservice.exception;

public class MailAlreadyExistsException extends RuntimeException {
    public MailAlreadyExistsException(String mail){
        super(String.format("%s Mail Already Exists", mail));
    }
}
