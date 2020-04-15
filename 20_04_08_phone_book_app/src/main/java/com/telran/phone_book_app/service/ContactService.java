package com.telran.phone_book_app.service;

import com.telran.phone_book_app.dto.AddressDTO;
import com.telran.phone_book_app.dto.ContactDTO;
import com.telran.phone_book_app.dto.PhoneNumberDTO;
import com.telran.phone_book_app.entity.Contact;
import com.telran.phone_book_app.entity.ContactAddress;
import com.telran.phone_book_app.entity.PhoneNumber;
import com.telran.phone_book_app.repository.IAddressRepo;
import com.telran.phone_book_app.repository.IContactRepo;
import com.telran.phone_book_app.repository.IPhoneNumberRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ContactService {
    private IContactRepo contactRepo;
    private IAddressRepo addressRepo;
    private IPhoneNumberRepo phoneNumberRepo;

    public ContactDTO getContact(int id){
        Contact contact = contactRepo.find(id);
        List<ContactAddress> addresses = addressRepo.findAllByContact(id);//it's data from DB
        List<PhoneNumber> numbers = phoneNumberRepo.findAllByContact(id);

        ContactDTO contactOut = new ContactDTO();
        //TODO move contact data to contactDTO data

        contactOut.addresses = addresses.stream()
                .map(address->{
                    AddressDTO res = new AddressDTO();

                    //TODO move data from address to addressDTO data (maybe need constructor)
                    return res;
                })
                .collect(Collectors.toList());

        contactOut.numbers = numbers.stream()
                .map(address->{
                    PhoneNumberDTO res = new PhoneNumberDTO();
                    //TODO move data from phone number to PhoneDTO data (maybe need constructor)
                    return res;
                })
                .collect(Collectors.toList());
        return contactOut;
    }



    public ContactService(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public void create(Contact contact) {
        contactRepo.add(contact);
    }

    public Contact get(int id) {
        return contactRepo.find(id);
    }

    public Contact remove (int id) {return  contactRepo.remove(id);}

    public void edit (Contact contact) {
        contactRepo.edit(contact);
    }

    public List<Contact> getAll() {
        return contactRepo.findAll();
    }

    public List<Contact> searchByName(String name) {
        return contactRepo.findAllByName(name);
    }

    public List<Contact> searchByLastName(String lastName) {
        return contactRepo.findAllByLastName(lastName);
    }

}
