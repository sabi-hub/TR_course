package com.telran.phone_book_app.entity;

public class PhoneNumber {

    private int phoneId;
    private Contact contact;
    private int phoneCode;
    private long phoneNumber;
    private PhoneType type;


    public PhoneNumber() {
    }

    public int getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(int phoneCode) {
        this.phoneCode = phoneCode;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }
}
