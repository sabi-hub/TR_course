package com.telran.person.persistence;

import com.telran.person.entity.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IPersonRepo extends CrudRepository <Person, Integer> {

    public List<Person> findByName(String name);

    //findAll consists in the CrudRepository, but it iterable, what means, that it without streams.
    //If we want to use streams, we create own method "findAll" without implementation.
    public List<Person> findAll();

//    public List<Person> findByBirthdayBetween(LocalDate earliestBirthday, LocalDate latestBirthday);

//    @Query("select p from Person  p where p.birthday>=?1 and p.birthday<=?2")
//    public List<Person> findByBirthdayBetweenCustom (LocalDate earliestBirthday, LocalDate latestBirthday);

    @Query("select p from Person  p where p.birthday>=:lower and p.birthday<=:upper")
    public List<Person> findByBirthdayBetweenCustom (
            @Param("lower") LocalDate earliestBirthday,
            @Param("upper") LocalDate latestBirthday);

    @Modifying //permission for changes in BD
    @Query("delete from Person p where p.birthday<?1")
    public void removeTooYoung(LocalDate upperBound);
}
