package com.springboottdd.springboottdd.resource;

import com.springboottdd.springboottdd.model.Person;
import com.springboottdd.springboottdd.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonResource {

    private final PersonService personService;

    @Autowired
    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("{name}/{tc}")
    public ResponseEntity<Person> getPersonByNameAndTc(@PathVariable("name") String name,
                                               @PathVariable("tc") String tc){

        Person person = new Person();
        person.setName("mehmet");
        person.setTc("3313666945");
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }
}
