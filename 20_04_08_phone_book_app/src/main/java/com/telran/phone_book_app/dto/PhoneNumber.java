package com.telran.phone_book_app.dto;

public class PhoneNumber {

    private String phoneId;
    private Contact contact;
    private int phoneCode;
    private long phoneNumber;
    private String phoneType;

    public PhoneNumber(String phoneId, Contact contact, int phoneCode, long phoneNumber, String phoneType) {
        this.phoneId = phoneId;
        this.contact = contact;
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
    }

    public PhoneNumber() {
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
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

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
