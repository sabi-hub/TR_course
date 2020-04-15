package com.telran.phone_book_app.repository;

import com.telran.phone_book_app.entity.Contact;

import java.util.List;

public interface IContactRepo {

    void add(Contact contact);

    void edit(Contact contact);

    Contact find (int id);

    Contact remove(int id);

    boolean remove (Contact contact);

    List<Contact> findAll();

    List<Contact> findAllByName(String pattern);

    List<Contact> findAllByLastName(String pattern);

}
