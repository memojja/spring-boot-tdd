package com.springboottdd.springboottdd.service;

import com.springboottdd.springboottdd.model.Person;
import com.springboottdd.springboottdd.model.Telephone;
import com.springboottdd.springboottdd.service.exception.SameTcException;
import com.springboottdd.springboottdd.service.exception.SamteTelephoneException;
import com.springboottdd.springboottdd.service.exception.TelephoneNotFoundException;

public interface PersonService {


    Person save(Person person) throws SameTcException, SamteTelephoneException;

    Person callByTelephone(Telephone telephone) throws TelephoneNotFoundException;
}
