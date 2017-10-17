package com.springboottdd.springboottdd.service.impl;

import com.springboottdd.springboottdd.model.Person;
import com.springboottdd.springboottdd.repository.PersonRepository;
import com.springboottdd.springboottdd.service.PersonService;
import com.springboottdd.springboottdd.service.exception.SameTcException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PersonServiceImpl implements PersonService {


    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public Person save(Person person) throws SameTcException {

        Optional<Person> person1 = Optional.ofNullable(personRepository.findByTc(person.getTc()));
        if(person1.isPresent()){
            throw new SameTcException();
        }
        return personRepository.save(person);
    }
}
