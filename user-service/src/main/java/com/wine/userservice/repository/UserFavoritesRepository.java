package com.wine.userservice.repository;

import com.wine.userservice.domain.entity.Item;
import com.wine.userservice.domain.entity.User;
import com.wine.userservice.domain.entity.UserFavorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFavoritesRepository extends JpaRepository<UserFavorites, String> {
    Iterable<UserFavorites> findAllByItemId(String itemId);
    Iterable<UserFavorites> findAllByUserId(Long userId);
    void deleteByItemAndUser(Item item, User user);
    void deleteAllByUser(User user);
}
