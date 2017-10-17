package com.springboottdd.springboottdd;

import com.springboottdd.springboottdd.model.Address;
import com.springboottdd.springboottdd.model.Person;
import com.springboottdd.springboottdd.model.Telephone;
import com.springboottdd.springboottdd.repository.AddressRepository;
import com.springboottdd.springboottdd.repository.PersonRepository;
import com.springboottdd.springboottdd.repository.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbLoader implements CommandLineRunner{

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;
    private final TelephoneRepository telephoneRepository;

    @Autowired
    public DbLoader(PersonRepository personRepository, AddressRepository addressRepository, TelephoneRepository telephoneRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
        this.telephoneRepository = telephoneRepository;
    }


    @Override

    public void run(String... strings) throws Exception {

        Address address = new Address();
        Address address1 = new Address();
        address.setCity("City1");
        address1.setCity("City2");

        Telephone telephone = new Telephone();
        Telephone telephone1 = new Telephone();
        telephone.setNumber("5346233636");
        telephone.setNumber("2346233636");


        Person person = new Person();
        Person person1 = new Person();
        person.setName("Ali");
        person.setName("Hasan");


        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        addresses.add(address1);



        person.setTelephones(Arrays.asList(telephone,telephone1));
        person1.setTelephones(Arrays.asList(telephone,telephone1));

        person.setAddresses(addresses);
        person1.setAddresses(addresses);

        addressRepository.save(address1);
        addressRepository.save(address);
        telephoneRepository.save(telephone);
        telephoneRepository.save(telephone1);
        personRepository.save(person);
        personRepository.save(person1);



    }
}
