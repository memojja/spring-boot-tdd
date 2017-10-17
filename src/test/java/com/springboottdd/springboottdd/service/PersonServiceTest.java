package com.springboottdd.springboottdd.service;

import com.springboottdd.springboottdd.model.Person;
import com.springboottdd.springboottdd.repository.PersonRepository;
import com.springboottdd.springboottdd.service.exception.SameTcException;
import com.springboottdd.springboottdd.service.impl.PersonServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class PersonServiceTest {

    @MockBean
    private PersonRepository personRepository;
    private PersonService personService;
    private Person person;


    @Before
    public void setUp() throws Exception {
        personService = new PersonServiceImpl(personRepository);
        person = new Person();
        person.setName("John");
        person.setTc("123456789101");

//        when(personRepository.findByTc("123456789101")).thenReturn(Optional.empty());
    }

    @Test
    public void must_save_people_in_the_repository() throws Exception {

        personService.save(person);
        Person save = verify(personRepository).save(person);

    }

    @Test(expected = SameTcException.class)
    public void you_should_not_save_two_people_with_the_same_tc() throws Exception {

        when(personRepository.findByTc("123456789101")).thenReturn(person);
        personService.save(person);

    }
}
