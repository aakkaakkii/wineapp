package com.wine.authservice.api.model;

import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode()
@ToString()
@Accessors(chain = true)
@Builder
public class AccessTokenResponse {
    public String accessToken;
    public String expiresIn;
    public String refreshToken;
}
