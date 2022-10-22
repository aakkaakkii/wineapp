package com.wine.authserviceapi.model;

import lombok.Data;

@Data
public class UserRegistrationRequest {
    private String username;
    private String password;
    private String repeatPassword;
    private String mail;
}
