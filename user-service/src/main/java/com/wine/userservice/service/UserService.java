package com.wine.userservice.service;

import com.wine.userservice.domain.dto.UserDto;
import com.wine.userservice.domain.entity.User;
import com.wine.userservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<Long, UserDto, User, UserRepository>{

    @Autowired
    public UserService(UserRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public Class<UserDto> getDTOClass() {
        return UserDto.class;
    }
}
