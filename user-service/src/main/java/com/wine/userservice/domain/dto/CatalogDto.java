package com.wine.userservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class CatalogDto implements AbstractDto<Long> {
    private Long id;
    private UserDto user;
    private String description;
}
