package com.springboottdd.springboottdd.service;

import com.springboottdd.springboottdd.model.Person;
import com.springboottdd.springboottdd.service.exception.SameTcException;

public interface PersonService {


    Person save(Person person) throws SameTcException;
}
