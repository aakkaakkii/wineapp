package com.wine.authserviceapi.feign;

import com.wine.authserviceapi.dto.UserDto;
import com.wine.authserviceapi.model.UserRegistrationRequest;
import com.wine.authserviceapi.model.UserRequest;
import com.wine.authserviceapi.service.UserService;
import feign.Headers;
import feign.RequestLine;

public interface UserServiceClient extends UserService {
    @RequestLine(value = "POST /rest/v1/registration")
    @Headers("Content-Type: application/json")
    UserDto register(UserRegistrationRequest reg);

    @RequestLine(value = "POST /rest/v1/users")
    UserDto createUser(UserRequest user);


}
