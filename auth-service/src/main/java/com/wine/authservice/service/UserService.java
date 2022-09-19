package com.wine.authservice.service;

import com.wine.authservice.domain.dto.UserDto;
import com.wine.authservice.domain.entity.User;
import com.wine.authservice.exception.MailAlreadyExistsException;
import com.wine.authservice.exception.PasswordDontMatchException;
import com.wine.authservice.exception.UserAlreadyExistsException;
import com.wine.authservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        validateUser(entity.getUsername(), entity.getEmail());
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return super.create(entity);
    }

    @Override
    public UserDto update(UserDto entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return super.update(entity);
    }

    public Page<UserDto> loadAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(u-> modelMapper.map(u, UserDto.class));
    }

    public void validateUser(String username, String email) {
        if (repository.findByUsername(username) != null) {
            throw new UserAlreadyExistsException(username);
        }

        if (repository.findByEmail(email) != null) {
            throw new MailAlreadyExistsException(email);
        }
    }

    public void validateUser(String username, String email, String password, String repeatPassword) {
        validateUser(username, email);

        if (password == null || !password.equals(repeatPassword)) {
            throw new PasswordDontMatchException();
        }
    }
}
