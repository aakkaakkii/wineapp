package com.wine.userservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class UserAllFavoritesDto implements AbstractDto<Long> {
    private Long userId;
    private List<String> favoriteIds;
}
