package com.wine.authservice.controller;

import com.wine.authservice.domain.dto.PermissionDto;
import com.wine.authservice.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/permissions")
@RequiredArgsConstructor
public class PermissionRestController {
    private final PermissionService permissionService;

    @GetMapping
    public List<PermissionDto> loadAll() {
        return permissionService.loadAll();
    }

    @GetMapping("/{id}")
    public PermissionDto getById(@PathVariable Long id){
        return permissionService.getById(id);
    }

    @PostMapping
    public PermissionDto add(@RequestBody PermissionDto permission) {
        return permissionService.create(permission);
    }

    @PutMapping("/{id}")
    public PermissionDto update(@RequestBody PermissionDto permission) {
        return permissionService.update(permission);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        permissionService.deleteById(id);
    }
}
