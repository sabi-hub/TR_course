package com.telran.phone_book_app.repository;

import com.telran.phone_book_app.entity.ContactAddress;
import com.telran.phone_book_app.entity.PhoneNumber;

import java.util.List;

public interface IAddressRepo {

    void add(ContactAddress address);

    void edit(ContactAddress address);

    //todo: think about id: contactId+ownId; or Contact contact field and only ownId (than research could be by two parameters)
    ContactAddress find(int id);

    ContactAddress remove(String id);

    boolean remove(ContactAddress contactAddress);

    List<ContactAddress> findAll();

    List<ContactAddress> findAllByContact(int id);
}
