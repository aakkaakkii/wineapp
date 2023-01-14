package com.wine.authservice.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ListWrapper <T> {
    private Integer page;
    private Integer size;
    private Long total;
    private Integer totalPages;
    private List<T> content;
}
