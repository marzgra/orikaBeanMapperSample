package com.model.mapper.demo.service;

import com.model.mapper.demo.dto.PersonDto;
import com.model.mapper.demo.entity.Person;
import com.model.mapper.demo.mapper.PersonMapper;
import com.model.mapper.demo.mocks.PersonDtoMock;
import com.model.mapper.demo.mocks.PersonMock;
import com.model.mapper.demo.repository.PersonRepository;
import com.model.mapper.demo.service.impl.PersonServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class PersonServiceImplTest {

    @Mock
    private PersonMapper personMapper;

    @Mock
    private PersonRepository personRepository;

    private PersonServiceImpl personService;

    @Before
    public void before() {
        // tworzymy obiekt serwisu (implementacji) wstrzykując zmokowane dependencje,
        // zamiast tego można użyć @InjectMock, ale ma to swoje wady
        openMocks(this);
        personService = new PersonServiceImpl(personRepository, personMapper);
    }

    @After
    public void after() {
        // po każdym teście resetujemy mocki, np. po to, aby w kolejnym teście
        // odczytać poprawną ilość wywołań (verify(xxx, times(X))...)
        reset(personMapper, personRepository);
    }

    @Test
    public void shouldSaveUserInDB(){
        // given
        // PersonMock i PersonDtoMock to moje własne klasy przygotowane na potrzebę tego testu,
        // zamiast w każdym kolejnym teście tworzyć nowy obiekt dla Person i PersonDto
        // twoje, że za pomocą takiej klasy i metody statycznej -> jest to zastosowanie zasady DRY (don't repeat yourself)
        final PersonDto userToSave = PersonDtoMock.getBasicPersonDto();
        final Person person = PersonMock.getBasicPerson();

        // ponieważ nie testujemy tutaj mappera, wstrzykujemy go jako Mock i podajemy jak metoda 'map' ma odpowiedzieć przy wywołaniu z danymi argumentami
        given(personMapper.map(userToSave, Person.class)).willReturn(person);
        // 'any(Person.class)' oznacza, że interesuje nas każde wywołanie któ®e jako argument otrzymało obiekt klasy Person
        given(personRepository.save(any(Person.class))).willReturn(person);

        // when
        final Long savedUserId = personService.createUser(userToSave);

        // then
        // sprawdzamy, czy metoda 'save' została wywołana (tylko 1 raz). 'any' oznacza, że nie zależy nam na sprawdzeniu, z jakim argumentem
        // więc jakikolwiek argument jest OK
        verify(personRepository, times(1)).save(any());
        assertNotNull(savedUserId);
    }
}
