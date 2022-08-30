package com.wine.userserviceapi.service;

import com.wine.userserviceapi.dto.UserDto;

import java.util.List;

public interface UserService {
    /**
     * @return list of user
     */
    List<UserDto> loadUsers();

    /**
     * Returns user by id
     * @param id User's id
     */
    UserDto findUserById(Long id);
}
