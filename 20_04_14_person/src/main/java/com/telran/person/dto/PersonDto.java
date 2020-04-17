package com.telran.person.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.telran.person.validation.annotation.FullNameMaxLength;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@FullNameMaxLength(15)
public class PersonDto {

    public int id;

    @Size(max=10, min=1, message = "The first name '${validatedValue}' has wrong length")
    public String firstName;

    @Size(max=10, min=3, message = "{com.telran.person.second_name.validation.message}")
    public String lastName;

    @JsonFormat(pattern = "dd.MM.yyyy")
    //TODO sort out with Past/pastOrPresent and Future/FutureOrPresent
    //TODO write also a custom annotation validating more than 18 yo.
    public LocalDate birthday;

    public PersonDto() {
    }

    public PersonDto(int id, String firstName, String lastName, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
