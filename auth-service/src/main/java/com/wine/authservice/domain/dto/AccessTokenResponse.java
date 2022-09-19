package com.wine.authservice.domain.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;

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
