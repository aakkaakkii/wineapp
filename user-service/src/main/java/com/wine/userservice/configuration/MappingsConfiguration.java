package com.wine.userservice.configuration;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MappingsConfiguration {
    private final ModelMapper modelMapper;

}
