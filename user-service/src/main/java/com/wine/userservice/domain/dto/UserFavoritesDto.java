package com.wine.userservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class UserFavoritesDto implements AbstractDto<String> {
    private UserDto user;
    private ItemDto item;
}
