package com.wine.authservice.api.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode()
@ToString()
@Accessors(chain = true)
public class GroupDto implements AbstractDto<Long> {
    private Long id;
    private String name;
    private List<PermissionDto> permissions;
}
