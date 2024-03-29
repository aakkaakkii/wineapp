package com.wine.authservice.api.model;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    private String username;
    private String oldPassword;
    private String newPassword;
    private String repeatPassword;
}
