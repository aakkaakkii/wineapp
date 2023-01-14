package com.wine.authservice.api.model;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String email;
}
