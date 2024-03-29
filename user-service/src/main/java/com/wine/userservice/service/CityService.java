package com.wine.userservice.service;

import com.wine.userservice.domain.dto.CityDto;
import com.wine.userservice.domain.entity.City;
import com.wine.userservice.exception.EntityNotFoundException;
import com.wine.userservice.repository.CityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityService extends AbstractService<Long, CityDto, City, CityRepository>{
    @Autowired
    public CityService(CityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }

    @Override
    public Class<CityDto> getDTOClass() {
        return CityDto.class;
    }

    @Override
    public CityDto getById(Long id) {
        try {
            return super.getById(id);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }
}
