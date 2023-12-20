package com.model.mapper.demo.mocks;

import com.model.mapper.demo.dto.PersonDto;
import com.model.mapper.demo.entity.Person;

import static com.model.mapper.demo.mocks.MockedValues.*;

public final class PersonDtoMock {

    private PersonDtoMock() {
    }

    public static PersonDto getBasicPersonDto() {
        PersonDto personDto = new PersonDto();
        personDto.setPersonId(ID);
        personDto.setFirstName(FIRST_NAME);
        personDto.setLastName(LAST_NAME);

        return personDto;
    }

}
