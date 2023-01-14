package com.wine.userservice.service;

import com.wine.authservice.api.feign.UserServiceClient;
import com.wine.authservice.api.model.UserRegistrationRequest;
import com.wine.userservice.domain.dto.UserDto;
import com.wine.userservice.domain.dto.UserRegistrationDto;
import com.wine.userservice.domain.entity.User;
import com.wine.userservice.repository.UserRepository;
import com.wine.userservice.api.model.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService extends AbstractService<Long, UserDto, User, UserRepository> {
    private final CityService cityService;
    private final UserServiceClient userServiceClient;

    @Autowired
    public UserService(UserRepository repository, ModelMapper modelMapper,
                       CityService cityService, UserServiceClient userServiceClient) {
        super(repository, modelMapper);
        this.cityService = cityService;
        this.userServiceClient = userServiceClient;
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public Class<UserDto> getDTOClass() {
        return UserDto.class;
    }

    public UserDto signUp(UserRegistrationDto userRegistrationDto) {
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setUsername(userRegistrationDto.getUsername());
        userRegistrationRequest.setMail(userRegistrationDto.getEmail());
        userRegistrationRequest.setPassword(userRegistrationDto.getPassword());
        userRegistrationRequest.setRepeatPassword(userRegistrationDto.getRepeatPassword());
        com.wine.authservice.api.dto.UserDto createdUser = userServiceClient.register(userRegistrationRequest);

        UserDto userDto = new UserDto();

        userDto.setPhoneNumber(userRegistrationDto.getPhoneNumber());
        userDto.setBirthdate(userRegistrationDto.getBirthDate());
        userDto.setCity(cityService.getById(userRegistrationDto.getCityId()));
        userDto.setName(userRegistrationDto.getName());
        userDto.setIsActivated(true);
        userDto.setCreateDate(Instant.now());
        userDto.setAuthId(createdUser.getId());

        return this.create(userDto);

    }

    public boolean existsByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber) != null;
    }

    public User getUserById(Long id) {
        return repository.findUserById(id);
    }


    public Page<UserResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(user -> modelMapper.map(user, UserResponse.class));
    }

    public List<UserDto> getAll() {
        return repository.findAll().stream().map(user -> modelMapper.map(user, getDTOClass())).collect(Collectors.toList());
    }
}
