package com.telran.person.service;

import com.telran.person.dto.NumberDto;
import com.telran.person.dto.NumberDtoBuilder;
import com.telran.person.dto.PersonDto;
import com.telran.person.entity.Person;
import com.telran.person.mapper.NumberMapper;
import com.telran.person.mapper.PersonMapper;
import com.telran.person.persistence.INumberRepo;
import com.telran.person.persistence.IPersonRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private IPersonRepo personRepo;
    @Mock
    private INumberRepo numberRepo;
    @Mock
    private PersonMapper personMapper;
    @Mock
    private NumberMapper numberMapper;

    @InjectMocks
    PersonService personService;

    @Captor
    ArgumentCaptor<Person> personCaptore;

    @Test
    public void testCreate_personWithoutNumbers_onePersonAndNoNumbersSaved() {
        LocalDate birthday = LocalDate.now().minusYears(25);
        PersonDto personDto = new PersonDto(5, "Vasily", "Kotov", birthday);

        personService.create(personDto);

//        verify(personRepo).save(argThat(
//                person -> person.getName().equals(personDto.firstName) &&
//                        person.getLastName().equals(personDto.lastName) &&
//                        person.getBirthday().equals(personDto.birthday)));

        verify(personRepo).save(personCaptore.capture());

        List<Person> capturedPersons = personCaptore.getAllValues();
        assertEquals(1, capturedPersons.size());

        Person person = capturedPersons.get(0);
        assertEquals(personDto.firstName, person.getName());
        assertEquals(personDto.lastName, person.getLastName());
        assertEquals(personDto.birthday, person.getBirthday());
    }

    @Test
    public void testCreate_personWithOneNumber_onePersonAndOneNumberSaved() {
        LocalDate birthday = LocalDate.now().minusYears(25);
        PersonDto personDto = new PersonDto(5, "Vasily", "Kotov", birthday);

        //for aside builder (NumberDToBuilder)
//        NumberDto numberDto = new NumberDtoBuilder()
//                .setNumber("number1")
//                .build();

        NumberDto numberDto = NumberDto.builder()
                .number("number1")
                .build();
        personDto.numbers = Collections.singletonList(numberDto);

        personService.create(personDto);

        verify(personRepo).save(personCaptore.capture());
        List<Person> capturedPersons = personCaptore.getAllValues();
        assertEquals(1, capturedPersons.size());
        Person capturedPerson = capturedPersons.get(0);

        verify(numberRepo, times(1)).save(any());
        verify(numberRepo).save(argThat(
                number -> number.getNumber().equals(numberDto.number) &&
                        number.getPerson().equals(capturedPerson)));
    }

    @Test
    public void testCreate_personWithTwoNumber_onePersonAndTwoNumbersSaved() {
        LocalDate birthday = LocalDate.now().minusYears(25);
        PersonDto personDto = new PersonDto(5, "Vasily", "Kotov", birthday);

        NumberDto numberDto1 = NumberDto.builder()
                .number("number1")
                .build();
        NumberDto numberDto2 = NumberDto.builder()
                .number("number2")
                .build();
        personDto.numbers = Arrays.asList(numberDto1, numberDto2);

        personService.create(personDto);

        verify(personRepo).save(personCaptore.capture());
        Person capturedPerson = personCaptore.getValue();

        verify(numberRepo, times(2)).save(any());
        verify(numberRepo,times(1)).save(argThat(
                number -> number.getNumber().equals(numberDto1.number) &&
                        number.getPerson().equals(capturedPerson)));
        verify(numberRepo,times(1)).save(argThat(
                number -> number.getNumber().equals(numberDto2.number) &&
                        number.getPerson().equals(capturedPerson)));
//        verify(numberRepo,never()).save(argThat(
//                number -> number.getNumber().equals(numberDto2.number) &&
//                        number.getPerson().equals("kein")));
    }
}