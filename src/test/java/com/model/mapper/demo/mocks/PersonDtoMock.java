package com.model.mapper.demo.mocks;

import com.model.mapper.demo.dto.PersonDto;
import com.model.mapper.demo.entity.Person;

public final class PersonDtoMock {

    private PersonDtoMock() {
    }

    public static PersonDto getBasicPersonDto() {
        PersonDto personDto = new PersonDto();
        personDto.setPersonId(1L);
        personDto.setFirstName("ABC");
        personDto.setLastName("DEF");

        return personDto;
    }

}
