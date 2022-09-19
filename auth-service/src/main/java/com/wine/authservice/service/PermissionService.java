package com.wine.authservice.service;

import com.wine.authservice.domain.dto.PermissionDto;
import com.wine.authservice.domain.entity.Permission;
import com.wine.authservice.repository.PermissionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionService extends
        AbstractService<Long, PermissionDto, Permission, PermissionRepository> {

    PermissionService(PermissionRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

    @Override
    public Class<Permission> getEntityClass() {
        return Permission.class;
    }

    @Override
    public Class<PermissionDto> getDTOClass() {
        return PermissionDto.class;
    }

    public List<PermissionDto> loadAll() {
        return repository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
