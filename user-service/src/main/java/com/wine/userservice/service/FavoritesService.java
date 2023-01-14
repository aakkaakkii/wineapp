package com.wine.userservice.service;

import com.wine.userservice.domain.dto.UserFavoritesDto;
import com.wine.userservice.domain.entity.Item;
import com.wine.userservice.domain.entity.User;
import com.wine.userservice.domain.entity.UserFavorites;
import com.wine.userservice.repository.UserFavoritesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FavoritesService
        extends AbstractService<String, UserFavoritesDto, UserFavorites, UserFavoritesRepository> {
    private final UserService userService;
    private final ItemService itemService;

    @Autowired
    public FavoritesService(UserFavoritesRepository repository, ModelMapper modelMapper,
                            UserService userService, ItemService itemService) {
        super(repository, modelMapper);
        this.userService = userService;
        this.itemService = itemService;
    }

    @Override
    public Class<UserFavorites> getEntityClass() {
        return UserFavorites.class;
    }

    @Override
    public Class<UserFavoritesDto> getDTOClass() {
        return UserFavoritesDto.class;
    }

    public List<UserFavoritesDto> findUsersByWineId(String id) {
        List<UserFavoritesDto> listSubscriptionDtoList = new ArrayList<>();
        for(UserFavorites listSubscriptionDto : repository.findAllByItemId(id)) {
            listSubscriptionDtoList.add(modelMapper.map(listSubscriptionDto, getDTOClass()));
        }
        return listSubscriptionDtoList;
    }

    public List<Long> findUserIdsByWineId(String id) {
        List<Long> userIds = new ArrayList<>();
        for (UserFavorites listSubscriptionDto : repository.findAllByItemId(id)) {
            userIds.add(listSubscriptionDto.getUser().getId());
        }
        return userIds;
    }

    public void removeUserFavoritesItem(Long itemId, Long userId) {
        User user = userService.getUserById(userId);
        Item item = itemService.getItemById(itemId);
        repository.deleteByItemAndUser(item, user);
    }

    public void clearUserFavorites(Long userId) {
        User user = userService.getUserById(userId);
        repository.deleteAllByUser(user);
    }
}
