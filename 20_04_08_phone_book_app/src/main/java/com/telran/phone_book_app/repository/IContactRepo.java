package com.telran.phone_book_app.repository;

import com.telran.phone_book_app.dto.Contact;

import java.util.List;

public interface IContactRepo {

    void add(Contact contact);

    void edit(Contact contact);

    Contact get(int id);

    Contact remove(int id);

    List<Contact> getAll();

    List<Contact> searchByName(String name);

    List<Contact> searchByLastName(String lastName);

}
