package com.telran.person.persistence;

import com.telran.person.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepo extends CrudRepository <Person, Integer> {

    public List<Person> findByName(String name);

    //findAll consists in the CrudRepository, but it iterable, what means, that it without streams.
    //If we want to use streams, we create own method "findAll" without implementation.
    public List<Person> findAll();
}
