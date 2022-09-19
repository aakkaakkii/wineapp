package com.wine.authservice.service;

import com.wine.authservice.domain.dto.UserDto;
import com.wine.authservice.domain.dto.UserRegistrationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserService userService;

    public UserDto register(UserRegistrationRequestDto reg) {
        userService.validateUser(reg.getUsername(), reg.getMail(), reg.getPassword(), reg.getRepeatPassword());

        UserDto userDto = new UserDto()
                .setUsername(reg.getUsername())
                .setEmail(reg.getMail())
                .setPassword(reg.getPassword())
                .setBlocked(false)
                .setActive(true); //temporary solution before activation

        //TODO: sent activation mail
        return userService.create(userDto);
    }

}
