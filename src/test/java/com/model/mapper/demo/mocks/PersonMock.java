package com.model.mapper.demo.mocks;

import com.model.mapper.demo.entity.Person;

public final class PersonMock {

    private PersonMock() {
    }

    public static Person getBasicPerson() {
        Person person = new Person();
        person.setPersonId(1L);
        person.setFirstName("Anna");
        person.setSurname("DEF");

        return person;
    }

}
