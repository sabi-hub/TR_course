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

    @Test
    @Transactional
    public void testFindByName_threePersonsInDb_twoFound() {
        LocalDate birthday = LocalDate.now().minusYears(11);
        Person person1 = new Person("Vasya", "Kotov", birthday);
        Person person2 = new Person("Vasya", "Vasin", birthday);
        Person person3 = new Person("Petya", "Vasin", birthday);

        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);
        entityManager.flush();

        List<Person> personsFromDb = personRepo.findByName("Vasya");

        assertEquals(2,personsFromDb.size());
        assertEquals("Vasya", personsFromDb.get(0).getName());
        assertEquals("Kotov", personsFromDb.get(0).getLastName());
        assertEquals(birthday, personsFromDb.get(0).getBirthday());
        assertEquals("Vasya", personsFromDb.get(1).getName());
        assertEquals("Vasin", personsFromDb.get(1).getLastName());
        assertEquals(birthday, personsFromDb.get(1).getBirthday());
    }

    @Test
    @Transactional
    public void testFindAll_onePersonInDb_oneFound() {
        LocalDate birthday = LocalDate.now().minusYears(11);
        Person person = new Person("Vasya", "Kotov", birthday);

        entityManager.persist(person);
        entityManager.flush();

        List<Person> personsFromDb = personRepo.findAll();

        assertEquals(1,personsFromDb.size());
        assertEquals("Vasya", personsFromDb.get(0).getName());
        assertEquals("Kotov", personsFromDb.get(0).getLastName());
        assertEquals(birthday, personsFromDb.get(0).getBirthday());
    }

    @Test
    @Transactional
    public void testFindAll_threePersonsInDb_allFound() {
        LocalDate birthday = LocalDate.now().minusYears(11);
        Person person1 = new Person("Vasya", "Kotov", birthday);
        Person person2 = new Person("Masha", "Mashina", birthday);
        Person person3 = new Person("Petya", "Vasin", birthday);

        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);
        entityManager.flush();

        List<Person> personsFromDb = personRepo.findAll();

        assertEquals(3,personsFromDb.size());
        assertEquals("Vasya", personsFromDb.get(0).getName());
        assertEquals("Masha", personsFromDb.get(1).getName());
        assertEquals("Petya", personsFromDb.get(2).getName());
    }

    @Test
    @Transactional
    public void testFindByBirthday_onePersonInDb_oneFound() {
        LocalDate earliest = LocalDate.now().minusYears(15);
        LocalDate latest = LocalDate.now().plusYears(1);
        LocalDate birthday = LocalDate.now().minusYears(11);
        Person person = new Person("Vasya", "Kotov", birthday);

        entityManager.persist(person);
        entityManager.flush();

        List<Person> personsFromDb = personRepo.findByBirthdayBetweenCustom(earliest,latest);

        assertEquals(1,personsFromDb.size());
        assertEquals("Vasya", personsFromDb.get(0).getName());
        assertEquals("Kotov", personsFromDb.get(0).getLastName());
        assertEquals(birthday, personsFromDb.get(0).getBirthday());
    }

    @Test
    @Transactional
    public void testFindByBirthday_threePersonsInDbWithDifferentBirthday_twoFoundWithDifferentBirthdays() {
        LocalDate earliest = LocalDate.now().minusYears(15);
        LocalDate latest = LocalDate.now().plusYears(1);
        LocalDate birthday = LocalDate.now().minusYears(11);
        LocalDate birthday1 = LocalDate.now().minusYears(8);
        LocalDate birthday2 = LocalDate.now().minusYears(17);
        Person person1 = new Person("Vasya", "Kotov", birthday1);
        Person person2 = new Person("Vasya", "Vasin", birthday2);
        Person person3 = new Person("Petya", "Vasin", birthday);

        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);
        entityManager.flush();

        List<Person> personsFromDb = personRepo.findByBirthdayBetweenCustom(earliest,latest);

        assertEquals(2,personsFromDb.size());
        assertEquals("Vasya", personsFromDb.get(0).getName());
        assertEquals("Petya", personsFromDb.get(1).getName());
    }

    @Test
    @Transactional
    public void testFindByBirthday_threePersonsInDb_noFound() {
        LocalDate earliest = LocalDate.now().minusYears(10);
        LocalDate latest = LocalDate.now().plusYears(1);
        LocalDate birthday = LocalDate.now().minusYears(11);
        LocalDate birthday2 = LocalDate.now().minusYears(17);
        Person person1 = new Person("Vasya", "Kotov", birthday);
        Person person2 = new Person("Vasya", "Vasin", birthday2);
        Person person3 = new Person("Petya", "Vasin", birthday);

        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);
        entityManager.flush();

        List<Person> personsFromDb = personRepo.findByBirthdayBetweenCustom(earliest,latest);

        assertEquals(0,personsFromDb.size());
    }
}