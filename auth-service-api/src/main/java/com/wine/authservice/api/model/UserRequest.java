package com.wine.authservice.api.model;

import lombok.Data;

import java.util.List;

@Data
public class UserRequest {
    private Long id;
    private String username;
    private String password;
    private String email;
    private boolean active;
    private boolean blocked;
    private List<Long> permissions;
    private List<Long> groups;
}
