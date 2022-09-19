package com.wine.authservice.domain.dto;

import lombok.Data;

@Data
public class ResetPasswordRequestDto {
    private String email;
}
