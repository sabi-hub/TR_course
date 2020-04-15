package com.telran.phone_book_app.repository;

import com.telran.phone_book_app.entity.ContactAddress;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class MemoryAddressRepo implements IAddressRepo {

    static final String DELIMITER_ID = "#";
    static final String SYMBOL_ID = "A";

    Map<String, ContactAddress> source = new HashMap<>();
    private AtomicInteger currentId = new AtomicInteger();

    @Override
    public void add(ContactAddress address) {
        String id = address.getContact().getContactId() + DELIMITER_ID + SYMBOL_ID;
        source.put(id + currentId.incrementAndGet(), address);
        address.setAddressId(id + currentId.get());
    }

    @Override
    public void edit(ContactAddress address) {
        source.replace(address.getAddressId(), address);
    }

    @Override
    public ContactAddress find(String id) {
        return source.get(id);
    }

    @Override
    public ContactAddress remove(String id) {
        return source.remove(id);
    }

    @Override
    public List<ContactAddress> findAll() {
        return source
                .values()
                .stream()
                .sorted(Comparator.comparing(ContactAddress::getAddressId))
                .collect(Collectors.toList());
    }
}
