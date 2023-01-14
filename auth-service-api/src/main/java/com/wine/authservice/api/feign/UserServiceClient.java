package com.wine.authservice.api.feign;

import com.wine.authservice.api.dto.UserDto;
import com.wine.authservice.api.model.UserRegistrationRequest;
import com.wine.authservice.api.model.UserRequest;
import com.wine.authservice.api.service.AuthUserService;
import feign.Headers;
import feign.RequestLine;

public interface UserServiceClient extends AuthUserService {
    @RequestLine(value = "POST /rest/v1/registration")
    @Headers("Content-Type: application/json")
    UserDto register(UserRegistrationRequest reg);

    @RequestLine(value = "POST /rest/v1/users")
    UserDto createUser(UserRequest user);


}
