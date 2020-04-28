package com.telran.phone_book_app.service;

import com.telran.phone_book_app.dto.Contact;
import com.telran.phone_book_app.dto.PhoneNumber;
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
        return phoneNumberRepo.get(id);
    }

    public PhoneNumber remove (String id) {return  phoneNumberRepo.remove(id);}

    public void edit (PhoneNumber phoneNumber) {
        phoneNumberRepo.edit(phoneNumber);
    }

    public List<PhoneNumber> getAll() {
        return phoneNumberRepo.getAll();
    }

    public List<Contact> searchByPhoneNumber(long number){return phoneNumberRepo.searchByPhoneNumber(number);}
}
