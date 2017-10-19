package com.springboottdd.springboottdd.repository;

import com.springboottdd.springboottdd.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

//https://github.com/Heo-Won-Chul/SpringBootSample/blob/master/
// SpringBootJpa/src/test/java/com/example/EntityManagerTests.java

//http://www.baeldung.com/spring-boot-testing


//@Sql(value = "/load-database.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = "/clean-database.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@DataJpaTest
//@TestPropertySource("classpath:application-test.properties")
@RunWith(SpringRunner.class)
public class PersonRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    PersonRepository personRepository;

    @Test
//    @Transactional
    public void should_look_for_people_by_tc() throws Exception {

        //given
        Person person = new Person();
//        person.setId(1L);
        person.setTc("123");
        person.setName("John");

        entityManager.persist(person);
        entityManager.flush();

//        //when
//        Person testedPerson = entityManager.find(Person.class,1L);
        Person testedPerson = personRepository.findOne(1L);

        //then
        assertThat(testedPerson.getTc()).isEqualTo(person.getTc());

    }
}
