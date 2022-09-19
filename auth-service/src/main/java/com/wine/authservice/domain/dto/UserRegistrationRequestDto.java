package com.wine.authservice.domain.dto;

import lombok.Data;

@Data
public class UserRegistrationRequestDto {
    private String username;
    private String password;
    private String repeatPassword;
    private String mail;
}
