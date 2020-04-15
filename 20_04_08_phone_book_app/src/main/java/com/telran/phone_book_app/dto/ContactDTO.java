package com.telran.phone_book_app.dto;

import com.telran.phone_book_app.entity.ContactAddress;
import com.telran.phone_book_app.entity.PhoneNumber;

import java.time.LocalDate;
import java.util.List;

public class ContactDTO {

    public int id;
    public String name;
    public String lastName;
    public LocalDate date;

    public List<AddressDTO> addresses;
    public List<PhoneNumberDTO> numbers;
}
