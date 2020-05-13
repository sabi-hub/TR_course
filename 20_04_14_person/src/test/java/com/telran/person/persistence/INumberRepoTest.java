package com.telran.person.persistence;

import com.telran.person.entity.Number;
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
class INumberRepoTest {

    @Autowired
    INumberRepo numberRepo;

    @Autowired
    TestEntityManager entityManager;

    @Test
    @Transactional
    public void testFindByPersonId_onePersonOneNumber_oneNumberFound(){
        LocalDate birthday = LocalDate.now().minusYears(11);
        Person person = new Person("Vasya", "Kotov", birthday);
        entityManager.persist(person);
        entityManager.flush();

        Number number = new Number(person, "number1");

        entityManager.persist(number);
        entityManager.flush();

        List<Number> numbersFromDb = numberRepo.findByPersonId(1);

        assertEquals(1,numbersFromDb.size());
        assertEquals("number1", numbersFromDb.get(0).getNumber());
    }

    @Test
    @Transactional
    public void testFindByPersonId_onePersonThreeNumbers_threeNumbersFound(){
        LocalDate birthday = LocalDate.now().minusYears(11);
        Person person = new Person("Vasya", "Kotov", birthday);
        entityManager.persist(person);
        entityManager.flush();

        Number number1 = new Number(person, "number1");
        Number number2 = new Number(person, "number2");
        Number number3 = new Number(person, "number3");

        entityManager.persist(number1);
        entityManager.persist(number2);
        entityManager.persist(number3);
        entityManager.flush();

        List<Number> numbersFromDb = numberRepo.findByPersonId(1);

        assertEquals(3,numbersFromDb.size());
        assertEquals("number1", numbersFromDb.get(0).getNumber());
        assertEquals("number2", numbersFromDb.get(1).getNumber());
        assertEquals("number3", numbersFromDb.get(2).getNumber());
    }

    @Test
    @Transactional
    public void testFindByPersonId_threePersonWithDifferentQuantityNumbers_twoNumbersFound(){
        LocalDate birthday = LocalDate.now().minusYears(11);
        Person person1 = new Person("Vasya", "Kotov", birthday);
        Person person2 = new Person("Petya", "Kotov", birthday);
        Person person3 = new Person("Stepa", "Kotov", birthday);
        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);
        entityManager.flush();

        Number number1 = new Number(person1, "number1");
        Number number2 = new Number(person1, "number2");
        Number number3 = new Number(person1, "number3");
        Number number4 = new Number(person2, "number4");
        Number number5 = new Number(person2, "number5");
        Number number6 = new Number(person3, "number6");

        entityManager.persist(number1);
        entityManager.persist(number2);
        entityManager.persist(number3);
        entityManager.persist(number4);
        entityManager.persist(number5);
        entityManager.persist(number6);
        entityManager.flush();

        List<Number> numbersFromDb = numberRepo.findByPersonId(2);

        assertEquals(2,numbersFromDb.size());
        assertEquals("number4", numbersFromDb.get(0).getNumber());
        assertEquals("number5", numbersFromDb.get(1).getNumber());
    }

    @Test
    @Transactional
    public void testFindByPersonId_onePersonWithNumber_noNumberFound(){
        LocalDate birthday = LocalDate.now().minusYears(11);
        Person person = new Person("Vasya", "Kotov", birthday);
        entityManager.persist(person);
        entityManager.flush();

        Number number = new Number(person, "number1");

        entityManager.persist(number);
        entityManager.flush();

        List<Number> numbersFromDb = numberRepo.findByPersonId(2);

        assertEquals(0,numbersFromDb.size());
    }

    @Test
    @Transactional
    public void testGetByPerson_onePersonOneNumber_oneNumberFound(){
        LocalDate birthday = LocalDate.now().minusYears(11);
        Person person = new Person("Vasya", "Kotov", birthday);
        entityManager.persist(person);
        entityManager.flush();

        Number number = new Number(person, "number1");

        entityManager.persist(number);
        entityManager.flush();

        List<Number> numbersFromDb = numberRepo.getByPerson(person);

        assertEquals(1,numbersFromDb.size());
        assertEquals("number1", numbersFromDb.get(0).getNumber());
    }

    @Test
    @Transactional
    public void testGetByPerson_twoPersonWithTwoNumbers_twoNumberFound(){
        LocalDate birthday = LocalDate.now().minusYears(11);
        Person person1 = new Person("Vasya", "Kotov", birthday);
        Person person2 = new Person("Petya", "Kotov", birthday);
        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.flush();

        Number number1 = new Number(person1, "number1");
        Number number2 = new Number(person1, "number2");
        Number number3 = new Number(person2, "number3");
        Number number4 = new Number(person2, "number4");

        entityManager.persist(number1);
        entityManager.persist(number2);
        entityManager.persist(number3);
        entityManager.persist(number4);
        entityManager.flush();

        List<Number> numbersFromDb = numberRepo.getByPerson(person2);

        assertEquals(2,numbersFromDb.size());
        assertEquals("number3", numbersFromDb.get(0).getNumber());
        assertEquals("number4", numbersFromDb.get(1).getNumber());
    }
}