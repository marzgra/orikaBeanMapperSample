package com.model.mapper.demo.controller;

import com.model.mapper.demo.dto.PersonDto;
import com.model.mapper.demo.service.spi.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/person")
    public List<PersonDto> getAllPeople() {
        return personService.getAllUsers();
    }

    @PostMapping("/person")
    public Long createPerson(@RequestBody PersonDto personDto) {
        return personService.createUser(personDto);
    }
}
