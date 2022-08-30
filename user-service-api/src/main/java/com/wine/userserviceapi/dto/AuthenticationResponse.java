package com.wine.userserviceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class AuthenticationResponse {
    private String accessToken;
    private String refreshToken;

    private UserResponse user;
}
