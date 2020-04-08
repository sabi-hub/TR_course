package com.telran.phone_book_app.repository;

import com.telran.phone_book_app.dto.Contact;
import com.telran.phone_book_app.dto.PhoneNumber;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Repository
public class MemoryPhoneNumberRepo implements IPhoneNumberRepo {

    static final String DELIMITER_ID = "#";
    static final String SYMBOL_ID = "P";

    Map<String, PhoneNumber> source = new HashMap<>();
    private AtomicInteger currentId = new AtomicInteger();

    @Override
    public void add(PhoneNumber phoneNumber) {
        String id = phoneNumber.getContact().getContactId() + DELIMITER_ID + SYMBOL_ID;
        source.put(id + currentId.incrementAndGet(), phoneNumber);
        phoneNumber.setPhoneId(id + currentId.get());
    }

    @Override
    public void edit(PhoneNumber phoneNumber) {
        source.replace(phoneNumber.getPhoneId(), phoneNumber);
    }

    @Override
    public PhoneNumber get(String id) {
        return source.get(id);
    }

    @Override
    public PhoneNumber remove(String id) {
        return source.remove(id);
    }

    @Override
    public List<PhoneNumber> getAll() {
        return source
                .values()
                .stream()
                .sorted(Comparator.comparing(PhoneNumber::getPhoneId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Contact> searchByPhoneNumber(long number) {
        List<Contact> contactList = Collections.emptyList();
        List<PhoneNumber> phoneNumberList = source
                .values()
                .stream()
                .filter(phoneNumber -> LongStream.of(phoneNumber.getPhoneNumber()).equals(number))
                .collect(Collectors.toList());

        for(PhoneNumber phoneNumber:phoneNumberList){
            contactList.add(phoneNumber.getContact());
        }
        return contactList;
    }

}
