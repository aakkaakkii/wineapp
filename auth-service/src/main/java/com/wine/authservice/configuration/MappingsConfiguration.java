package com.wine.authservice.configuration;

import com.wine.authservice.domain.dto.GroupDto;
import com.wine.authservice.domain.dto.PermissionDto;
import com.wine.authservice.domain.dto.UserDto;
import com.wine.authserviceapi.model.UserRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class MappingsConfiguration {
    private final ModelMapper modelMapper;

    @PostConstruct
    private void configure() {
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        this.configureUserRequestMapping();
    }

    private void configureUserRequestMapping() {
        TypeMap<UserRequest, UserDto> typeMap =
                modelMapper.createTypeMap(UserRequest.class, UserDto.class);


        Converter<List<Long>, Set<PermissionDto>> permConverter = new AbstractConverter<>() {
            @Override
            protected Set<PermissionDto> convert(List<Long> permissions) {
                if (permissions == null) { return null; }
                return permissions.stream()
                        .map(s -> new PermissionDto(s, null))
                        .collect(Collectors.toSet());
            }
        };

        Converter<List<Long>, Set<GroupDto>> groupConverter = new AbstractConverter<>() {
            @Override
            protected Set<GroupDto> convert(List<Long> groups) {
                if (groups == null) { return null; }
                return groups.stream()
                        .map(s -> new GroupDto(s, null, null))
                        .collect(Collectors.toSet());
            }
        };

        typeMap.addMappings(mapper-> {
            mapper.using(permConverter).map(UserRequest::getPermissions, UserDto::setPermissions);
            mapper.using(groupConverter).map(UserRequest::getGroups, UserDto::setGroups);
        });

    }


}
