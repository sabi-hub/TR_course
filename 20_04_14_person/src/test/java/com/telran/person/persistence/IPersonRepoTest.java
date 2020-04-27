package com.telran.person.persistence;

import com.telran.person.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IPersonRepoTest {

    @Autowired
    IPersonRepo personRepo;

    @Autowired
    TestEntityManager entityManager;

    @Test
    @Transactional
    public void testFindByName_onePersonInDb_oneFound() {
        LocalDate birthday = LocalDate.now().minusYears(11);
        Person person = new Person("Vasya", "Kotov", birthday);

        entityManager.persist(person);
        entityManager.flush();

        List<Person> personsFromDb = personRepo.findByName("Vasya");

        assertEquals(1,personsFromDb.size());
        assertEquals("Vasya", personsFromDb.get(0).getName());
        assertEquals("Kotov", personsFromDb.get(0).getLastName());
        assertEquals(birthday, personsFromDb.get(0).getBirthday());
    }

    @Test
    @Transactional
    public void testFindByName_onePersonInDb_noFound() {
        LocalDate birthday = LocalDate.now().minusYears(11);
        Person person = new Person("Vasya", "Kotov", birthday);

        entityManager.persist(person);
        entityManager.flush();

        List<Person> personsFromDb = personRepo.findByName("Vasa");
        assertEquals(0,personsFromDb.size());
    }
}