package com.wine.userservice.service;

import com.wine.userservice.domain.dto.CompanyDto;
import com.wine.userservice.domain.entity.Company;
import com.wine.userservice.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyService extends AbstractService<Long, CompanyDto, Company, CompanyRepository> {
    @Autowired
    public CompanyService(CompanyRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

    @Override
    public Class<Company> getEntityClass() {
        return Company.class;
    }

    @Override
    public Class<CompanyDto> getDTOClass() {
        return CompanyDto.class;
    }
}
