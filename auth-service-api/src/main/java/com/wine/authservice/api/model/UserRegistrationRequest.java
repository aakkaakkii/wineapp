package com.wine.authservice.api.model;

import lombok.Data;

@Data
public class UserRegistrationRequest {
    private String username;
    private String password;
    private String repeatPassword;
    private String mail;
}
