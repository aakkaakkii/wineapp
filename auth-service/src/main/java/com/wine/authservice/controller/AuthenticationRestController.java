package com.wine.authservice.controller;

import com.wine.authservice.service.AuthenticationService;
import com.wine.authservice.api.model.AccessTokenResponse;
import com.wine.authservice.api.model.AuthenticationRequest;
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
    public AccessTokenResponse login(@RequestBody AuthenticationRequest auth) {
        return authenticationService.login(auth);
    }
}
