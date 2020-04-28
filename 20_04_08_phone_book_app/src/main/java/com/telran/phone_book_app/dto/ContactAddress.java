package com.telran.phone_book_app.dto;

public class ContactAddress {

    private String addressId;
    private Contact contact;
    private int zipCode;
    private String country;
    private String city;
    private String address;

    public ContactAddress(String addressId, Contact contact, int zipCode, String country, String city, String address) {
        this.addressId = addressId;
        this.contact = contact;
        this.zipCode = zipCode;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public ContactAddress() {
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
