package com.wine.authserviceapi.dto;

import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode()
@ToString()
@Accessors(chain = true)
public class PermissionDto implements AbstractDto<Long> {
    private Long id;
    private String name;
}
