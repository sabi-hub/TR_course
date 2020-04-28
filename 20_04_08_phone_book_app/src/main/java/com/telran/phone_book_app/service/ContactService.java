package com.telran.phone_book_app.service;

import com.telran.phone_book_app.dto.Contact;
import com.telran.phone_book_app.repository.IContactRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private IContactRepo contactRepo;

    public ContactService(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public void create(Contact contact) {
        contactRepo.add(contact);
    }

    public Contact get(int id) {
        return contactRepo.get(id);
    }

    public Contact remove (int id) {return  contactRepo.remove(id);}

    public void edit (Contact contact) {
        contactRepo.edit(contact);
    }

    public List<Contact> getAll() {
        return contactRepo.getAll();
    }

    public List<Contact> searchByName(String name) {
        return contactRepo.searchByName(name);
    }

    public List<Contact> searchByLastName(String lastName) {
        return contactRepo.searchByLastName(lastName);
    }

}
