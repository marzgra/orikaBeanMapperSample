package com.model.mapper.demo.service.impl;

import com.model.mapper.demo.dto.PersonDto;
import com.model.mapper.demo.entity.Person;
import com.model.mapper.demo.mapper.PersonMapper;
import com.model.mapper.demo.repository.PersonRepository;
import com.model.mapper.demo.service.spi.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper mapper;

    @Override
    public Long createUser(final PersonDto personDto) {
        final Person personToSave = mapper.map(personDto, Person.class);
        return personRepository.save(personToSave)
                .getPersonId();
    }

    @Override
    public List<PersonDto> getAllUsers() {
        return personRepository.findAll()
                .stream()
                .map(person -> mapper.map(person, PersonDto.class))
                .collect(toList());
    }
}
