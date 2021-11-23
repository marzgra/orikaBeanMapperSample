package com.model.mapper.demo.service.spi;

import com.model.mapper.demo.dto.PersonDto;

import java.util.List;

public interface PersonService {
    Long createUser(PersonDto personDto);
    List<PersonDto> getAllUsers();
}
