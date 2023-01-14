package com.wine.userservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class UserFavoritesPk implements Serializable {
    protected Long userId;
    protected String itemId;
}