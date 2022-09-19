package com.wine.authserviceapi.feign;

import com.wine.authserviceapi.dto.UserDto;
import com.wine.authserviceapi.dto.UserRegistrationRequestDto;
import com.wine.authserviceapi.service.UserService;
import feign.Headers;
import feign.RequestLine;

public interface UserServiceClient extends UserService {
    @RequestLine(value = "POST /rest/v1/registration")
    @Headers("Content-Type: application/json")
    UserDto register(UserRegistrationRequestDto reg);

}
