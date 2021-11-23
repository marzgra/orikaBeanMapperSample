package com.model.mapper.demo.mapper;

import com.model.mapper.demo.dto.PersonDto;
import com.model.mapper.demo.entity.Person;
import org.junit.jupiter.api.Test;

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
        assertEquals(person.getPersonId(), personDto.getPersonId());
        assertEquals(person.getFirstName(), personDto.getFirstName());
        assertEquals(person.getSurname(), personDto.getLastName());
    }

    @Test
    public void shouldMapPersonDtoToPerson() {
        // given
        PersonMapper personMapper = new PersonMapper();

        PersonDto personDto = new PersonDto();
        personDto.setPersonId(1L);
        personDto.setFirstName("ABC");
        personDto.setLastName("DEF");

        // when
        Person person = personMapper.map(personDto, Person.class);

        // then
        assertEquals(personDto.getPersonId(), person.getPersonId());

    }

}
