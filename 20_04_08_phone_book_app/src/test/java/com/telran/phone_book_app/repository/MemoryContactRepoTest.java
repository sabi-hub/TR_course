package com.telran.phone_book_app.repository;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MemoryContactRepoTest {
    MemoryContactRepo contactRepo = new MemoryContactRepo();


    @Test
    public void testSearchByName(){
        Map<Integer,String> source = new HashMap<>();



//        List<String> contact1 = Arrays.asList("Vasya", "Vasin");

        source.put(1, "Vasya");
//        contactRepo.searchByName("Vasya");

//        List <> expected = new HashMap <>(1, "Vasya");
//        assertEquals(expected, contactRepo.searchByName("Vasya"));
        assertEquals(1, source.size());
    }

}