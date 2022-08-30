package com.wine.userserviceapi.service;

import com.wine.userserviceapi.error.UnauthorizedException;

public interface AuthenticationService {

    /**
     * Returns nothing if validation succeeded
     * @param token access token to validate
     * @throws UnauthorizedException if failed
     */
    void validate(String token) throws UnauthorizedException;
}
