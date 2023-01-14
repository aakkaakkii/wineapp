package com.wine.userservice.api.feign;

import com.wine.userservice.api.dto.ItemDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface FavoritesServiceClient {
    /**
     * Returns list of user's favorites as list of ids
     * @param id - user id
     * @param role - user role
     */
    @RequestLine(value = "GET /favorites/list")
    @Headers({"Content-Type: application/json", "id: {id}", "role: {role}"})
    List<String> findUsersFavoritesIdList(@Param("id") String id, @Param("role") String role);

    /**
     * Returns list of user's favorites
     * @param id - user id
     * @param role - user role
     */
    @RequestLine(value = "GET /favorites/")
    @Headers({"Content-Type: application/json", "id: {id}", "role: {role}"})
    List<ItemDto> findUsersFavorites(@Param("id") String id, @Param("role") String role);
}
