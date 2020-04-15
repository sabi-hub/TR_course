package com.telran.phone_book_app.repository;

import com.telran.phone_book_app.entity.Contact;
import com.telran.phone_book_app.entity.ContactAddress;
import com.telran.phone_book_app.entity.PhoneNumber;

import java.util.List;

public interface IPhoneNumberRepo {

    void add(PhoneNumber phoneNumber);

    void edit(PhoneNumber phoneNumber);

    //todo: think about id: contactId+ownId; or Contact contact field and only ownId (than research could be by two parameters)
    PhoneNumber find(String id);

    PhoneNumber remove(String id);

    boolean remove(PhoneNumber phoneNumber);

    List<PhoneNumber> findAll();

    List<PhoneNumber> findAllByCodePlusNumber(String pattern);

    List<PhoneNumber> findAllByContact(int id);
}
