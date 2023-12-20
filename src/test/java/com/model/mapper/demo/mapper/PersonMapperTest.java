package com.model.mapper.demo.mapper;

import com.model.mapper.demo.dto.PersonDto;
import com.model.mapper.demo.entity.Person;
import org.junit.jupiter.api.Test;

import static com.model.mapper.demo.mocks.MockedValues.*;
import static com.model.mapper.demo.mocks.PersonMock.getBasicPerson;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PersonMapperTest {

    @Test
    public void shouldMapPersonToPersonDto() {
        // 1. utworzenie obiektu Person
        // 2. wywołanie mappera, który zwróci PersonDto
        // 3. porównanie wartości Person i PersonDto

        // given
        PersonMapper personMapper = new PersonMapper();
        Person person = getBasicPerson();

        // when
        final PersonDto personDto = personMapper.map(person, PersonDto.class);

        // then
        assertEquals(ID, personDto.getPersonId());
        assertEquals(FIRST_NAME, personDto.getFirstName());
        assertEquals(LAST_NAME, personDto.getLastName());
    }

    @Test
    public void shouldMapPersonDtoToPerson() {
        // given
        PersonMapper personMapper = new PersonMapper();

        PersonDto personDto = new PersonDto();
        personDto.setPersonId(ID);
        personDto.setFirstName(FIRST_NAME);
        personDto.setLastName(LAST_NAME);

        // when
        Person person = personMapper.map(personDto, Person.class);

        // then
        assertEquals(ID, person.getPersonId());
        assertEquals(FIRST_NAME, person.getFirstName());
        assertEquals(LAST_NAME, person.getSurname());

    }

}
