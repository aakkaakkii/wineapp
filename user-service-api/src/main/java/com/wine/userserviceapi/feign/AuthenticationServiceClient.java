package com.wine.userserviceapi.feign;

import com.wine.userserviceapi.error.UnauthorizedException;
import com.wine.userserviceapi.service.AuthenticationService;
import feign.Headers;
import feign.Param;
import feign.RequestLine;


public interface AuthenticationServiceClient extends AuthenticationService {
    @RequestLine(value = "POST /validate?token={token}")
    @Headers("Content-Type: application/json")
    void validate(@Param("token") String token) throws UnauthorizedException;
}
