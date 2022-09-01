package com.wine.authservice.service;

import com.wine.authservice.domain.dto.UserDto;
import com.wine.authservice.domain.entity.User;
import com.wine.authservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<Long, UserDto, User, UserRepository> {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        super(userRepository, modelMapper);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public Class<UserDto> getDTOClass() {
        return UserDto.class;
    }

    @Override
    public UserDto create(UserDto entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return super.create(entity);
    }

    @Override
    public void update(UserDto entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        super.update(entity);
    }
}
