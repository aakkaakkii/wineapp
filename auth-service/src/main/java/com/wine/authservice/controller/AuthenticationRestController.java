package com.wine.authservice.controller;

import com.wine.authservice.domain.dto.AccessTokenResponse;
import com.wine.authservice.domain.dto.AuthenticationRequestDto;
import com.wine.authservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/v1/auth")
public class AuthenticationRestController {
    private final AuthenticationService authenticationService;

    @PostMapping
    public AccessTokenResponse login(@RequestBody AuthenticationRequestDto auth) {
        return authenticationService.login(auth);
    }
}
