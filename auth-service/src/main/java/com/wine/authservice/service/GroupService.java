package com.wine.authservice.service;

import com.wine.authservice.domain.dto.GroupDto;
import com.wine.authservice.domain.entity.Group;
import com.wine.authservice.repository.GroupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService extends
        AbstractService<Long, GroupDto, Group, GroupRepository> {

    GroupService(GroupRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

    public List<GroupDto> loadAll() {
        return repository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Class<Group> getEntityClass() {
        return Group.class;
    }

    @Override
    public Class<GroupDto> getDTOClass() {
        return GroupDto.class;
    }
}
