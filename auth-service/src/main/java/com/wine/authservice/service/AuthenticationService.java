package com.wine.authservice.service;

import com.wine.authservice.domain.dto.AccessTokenResponse;
import com.wine.authservice.domain.dto.AuthenticationRequestDto;
import com.wine.authservice.domain.entity.User;
import com.wine.authservice.exception.PasswordDontMatchException;
import com.wine.authservice.exception.UserIsBlockedException;
import com.wine.authservice.exception.UserIsNotActiveException;
import com.wine.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AccessTokenResponse login(AuthenticationRequestDto auth) {
        User user = userRepository.findByUsername(auth.getUsername());

        if (!passwordEncoder.matches(auth.getPassword(), user.getPassword())) {
            throw new PasswordDontMatchException();
        }
        if (!user.isActive()) {
            throw new UserIsNotActiveException(auth.getUsername());
        }
        if (user.isBlocked()) {
            throw new UserIsBlockedException(auth.getPassword());
        }

        return AccessTokenResponse.builder()
                .accessToken(user.createAccessToken())
                .refreshToken(user.createRefreshToken())
                .build();
    }
}
