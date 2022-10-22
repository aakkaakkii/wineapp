package com.wine.authservice.repository;

import com.wine.authservice.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query("SELECT u FROM User u WHERE u.username=:username AND u.id<>:id")
    User findByUsernameNotEqualToId(@Param("username") String username, @Param("id") Long id);
    User findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.email=:email AND u.id<>:id")
    User findByEmailNotEqualToId(@Param("email") String email, @Param("id") Long id);
}
