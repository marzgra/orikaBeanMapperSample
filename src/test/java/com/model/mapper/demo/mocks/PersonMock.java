package com.model.mapper.demo.mocks;

import com.model.mapper.demo.entity.Person;

import static com.model.mapper.demo.mocks.MockedValues.*;

public final class PersonMock {

    private PersonMock() {
    }

    public static Person getBasicPerson() {
        Person person = new Person();
        person.setPersonId(ID);
        person.setFirstName(FIRST_NAME);
        person.setSurname(LAST_NAME);

        return person;
    }

}
