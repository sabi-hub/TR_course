package com.telran.phone_book_app.service;

import com.telran.phone_book_app.entity.Contact;
import com.telran.phone_book_app.entity.PhoneNumber;
import com.telran.phone_book_app.repository.IPhoneNumberRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberService {

    private IPhoneNumberRepo phoneNumberRepo;

    public PhoneNumberService(IPhoneNumberRepo phoneNumberRepo) {
        this.phoneNumberRepo = phoneNumberRepo;
    }

    public void create(PhoneNumber phoneNumber) {
        phoneNumberRepo.add(phoneNumber);
    }

    public PhoneNumber get(String id) {
        return phoneNumberRepo.find(id);
    }

    public PhoneNumber remove (String id) {return  phoneNumberRepo.remove(id);}

    public void edit (PhoneNumber phoneNumber) {
        phoneNumberRepo.edit(phoneNumber);
    }

    public List<PhoneNumber> getAll() {
        return phoneNumberRepo.findAll();
    }

    public List<Contact> searchByPhoneNumber(long number){return phoneNumberRepo.findAllByCodePlusNumber(number);}
}
