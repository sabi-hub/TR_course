package com.telran.phone_book_app.service;

import com.telran.phone_book_app.entity.ContactAddress;
import com.telran.phone_book_app.repository.IAddressRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactAddressService {

    private IAddressRepo addressRepo;

    public ContactAddressService(IAddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public void create(ContactAddress contactAddress) {
        addressRepo.add(contactAddress);
    }

    public ContactAddress get(String id) {
        return addressRepo.find(id);
    }

    public ContactAddress remove(String id) {
        return addressRepo.remove(id);
    }

    public void edit(ContactAddress contactAddress) {
        addressRepo.edit(contactAddress);
    }

    public List<ContactAddress> getAll() {
        return addressRepo.findAll();
    }
}
