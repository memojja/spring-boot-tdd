package com.springboottdd.springboottdd.service;

import com.springboottdd.springboottdd.model.Address;
import com.springboottdd.springboottdd.model.Person;
import com.springboottdd.springboottdd.model.Telephone;
import com.springboottdd.springboottdd.repository.PersonRepository;
import com.springboottdd.springboottdd.service.exception.SameTcException;
import com.springboottdd.springboottdd.service.exception.SamteTelephoneException;
import com.springboottdd.springboottdd.service.exception.TelephoneNotFoundException;
import com.springboottdd.springboottdd.service.impl.PersonServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
public class PersonServiceTest {

    @MockBean
    private PersonRepository personRepository;
    private PersonService personService;
    private Person person;
    private Telephone telephone;


    @Before
    public void setUp() throws Exception {
        personService = new PersonServiceImpl(personRepository);
        person = new Person();
        person.setName("John");
        person.setTc("123456789101");

        telephone = new Telephone();
        telephone.setNumber("5347894563");

        person.setTelephones(Arrays.asList(telephone));


//        when(personRepository.findByTc("123456789101")).thenReturn(Optional.empty());
//        when(personRepository.findByTelephones("5347894563")).thenReturn(Optional.empty());
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

    @Test(expected = SamteTelephoneException.class)
    public void not_to_save_two_person_with_same_phone() throws Exception {

        when(personRepository.findByTelephones(telephone)).thenReturn(person);

        personService.save(person);
    }

    @Test
    public void should_look_for_person_by_tc_and_phone_number() throws Exception {

        when(personRepository.findByTelephones(telephone)).thenReturn(person);

        Person testPerson = personService.callByTelephone(telephone);

        verify(personRepository).findByTelephones(telephone);

        assertThat(testPerson).isNotNull();
        assertThat(testPerson.getTc()).isEqualTo("123456789101");
    }


    @Test(expected = TelephoneNotFoundException.class)
    public void must_be_return_telephone_not_found() throws Exception {
        personService.callByTelephone(telephone);
    }

}
