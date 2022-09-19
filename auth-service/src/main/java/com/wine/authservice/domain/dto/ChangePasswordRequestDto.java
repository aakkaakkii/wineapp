package com.wine.authservice.domain.dto;

import lombok.Data;

@Data
public class ChangePasswordRequestDto {
    private String username;
    private String oldPassword;
    private String newPassword;
    private String repeatPassword;
}
