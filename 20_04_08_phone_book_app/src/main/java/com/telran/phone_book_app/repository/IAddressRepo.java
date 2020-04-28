package com.telran.phone_book_app.repository;

import com.telran.phone_book_app.dto.ContactAddress;

import java.util.List;

public interface IAddressRepo {

    void add(ContactAddress address);

    void edit(ContactAddress address);

    //todo: think about id: contactId+ownId; or Contact contact field and only ownId (than research could be by two parameters)
    ContactAddress get(String id);

    ContactAddress remove(String id);

    List<ContactAddress> getAll();
}
