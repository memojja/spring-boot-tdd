package com.springboottdd.springboottdd.service.impl;

import com.springboottdd.springboottdd.model.Person;
import com.springboottdd.springboottdd.model.Telephone;
import com.springboottdd.springboottdd.repository.PersonRepository;
import com.springboottdd.springboottdd.service.PersonService;
import com.springboottdd.springboottdd.service.exception.SameTcException;
import com.springboottdd.springboottdd.service.exception.SamteTelephoneException;
import com.springboottdd.springboottdd.service.exception.TelephoneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonService {


    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public Person save(Person person) throws SameTcException, SamteTelephoneException {

        Optional<Person> person1 = Optional.ofNullable(personRepository.findByTc(person.getTc()));

        Optional<Person> person2 = Optional.ofNullable(personRepository.findByTelephones(person.getTelephones().get(0)));

        if(person1.isPresent()){
            throw new SameTcException();
        }

        if(person2.isPresent()){
            throw new SamteTelephoneException();
        }
        return personRepository.save(person);
    }

    @Override
    public Person callByTelephone(Telephone telephone) throws TelephoneNotFoundException {

        Optional<Person> person = Optional.ofNullable(personRepository.findByTelephones(telephone));

        return person.orElseThrow( () ->  new TelephoneNotFoundException());
    }
}
