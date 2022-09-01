package com.wine.userservice.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String entityName, String id) {
        super(String.format("%s with id: %s is not found", entityName, id));
    }

    public EntityNotFoundException(String id) {
        this("Entity", id);
    }
}
