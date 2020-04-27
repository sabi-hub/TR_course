package com.telran.person.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.telran.person.validation.annotation.FullNameMaxLength;
import com.telran.person.validation.annotation.MoreThanYears;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@FullNameMaxLength(15)
@NoArgsConstructor
public class PersonDto {

    public int id;

    @NotNull
    @Size(max=10, min=1, message = "The first name '${validatedValue}' has wrong length")
    public String firstName;

    @NotNull
    @Size(max=10, min=3, message = "{com.telran.person.second_name.validation.message}")
    public String lastName;

    @JsonFormat(pattern = "dd.MM.yyyy")
//    @Past
    @MoreThanYears(18)
    public LocalDate birthday;

    public List<NumberDto> numbers = new ArrayList<>();

    public PersonDto(int id, String firstName, String lastName, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

}
