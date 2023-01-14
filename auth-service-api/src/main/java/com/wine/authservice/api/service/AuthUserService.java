package com.wine.authservice.api.service;

import com.wine.authservice.api.dto.UserDto;
import com.wine.authservice.api.model.UserRegistrationRequest;
import com.wine.authservice.api.model.UserRequest;

public interface AuthUserService {
    UserDto register(UserRegistrationRequest reg);
    UserDto createUser(UserRequest user);
}
