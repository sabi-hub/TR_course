package com.telran.person.dto;

import java.time.LocalDate;

public class PersonDto {

    public int id;
    public String firstName;
    public String lastName;
    public LocalDate birthday;

    public PersonDto(int id, String firstName, String lastName, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }
}
