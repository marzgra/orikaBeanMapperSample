package com.model.mapper.demo.controller;

import com.model.mapper.demo.dto.PersonDto;
import com.model.mapper.demo.entity.Person;
import com.model.mapper.demo.mapper.PersonMapper;
import com.model.mapper.demo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@AllArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonMapper mapper;

    @GetMapping("/person")
    public List<PersonDto> getAllPeople() {
        return personRepository.findAll()
                .stream()
                .map(person -> mapper.map(person, PersonDto.class))
                .collect(toList());
    }

    @PostMapping("/person")
    public Long createPerson(@RequestBody PersonDto personDto) {
        Person personToSave = mapper.map(personDto, Person.class);
        return personRepository.save(personToSave)
                .getPersonId();
    }
}
