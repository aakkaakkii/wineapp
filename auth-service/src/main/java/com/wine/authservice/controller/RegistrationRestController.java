package com.wine.authservice.controller;

import com.wine.authservice.domain.dto.UserDto;
import com.wine.authservice.service.RegistrationService;
import com.wine.authservice.api.model.UserRegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/registration")
@RequiredArgsConstructor
public class RegistrationRestController {
    private final RegistrationService registrationService;

    @PostMapping
    public UserDto register(@RequestBody UserRegistrationRequest reg) {
        return registrationService.register(reg);
    }

}
