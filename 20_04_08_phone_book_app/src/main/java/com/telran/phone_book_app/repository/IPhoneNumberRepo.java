package com.telran.phone_book_app.repository;

import com.telran.phone_book_app.dto.Contact;
import com.telran.phone_book_app.dto.PhoneNumber;

import java.util.List;

public interface IPhoneNumberRepo {

    void add(PhoneNumber phoneNumber);

    void edit(PhoneNumber phoneNumber);

    //todo: think about id: contactId+ownId; or Contact contact field and only ownId (than research could be by two parameters)
    PhoneNumber get(String id);

    PhoneNumber remove(String id);

    List<PhoneNumber> getAll();

    List<Contact> searchByPhoneNumber(long number);
}
