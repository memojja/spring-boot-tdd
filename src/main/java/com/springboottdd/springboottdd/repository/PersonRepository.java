package com.springboottdd.springboottdd.repository;

import com.springboottdd.springboottdd.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long>{

    Person findByTc(String person);
}
