package com.wine.userservice.repository;

import com.wine.userservice.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhoneNumber(String phoneNumber);
    User findUserById(Long id);
    User findByAuthId(Long id);
}
