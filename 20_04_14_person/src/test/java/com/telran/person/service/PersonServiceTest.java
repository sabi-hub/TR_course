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
import java.util.stream.Collectors;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;
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
        verify(numberRepo, times(1)).save(argThat(
                number -> number.getNumber().equals(numberDto1.number) &&
                        number.getPerson().equals(capturedPerson)));
        verify(numberRepo, times(1)).save(argThat(
                number -> number.getNumber().equals(numberDto2.number) &&
                        number.getPerson().equals(capturedPerson)));
//        verify(numberRepo,never()).save(argThat(
//                number -> number.getNumber().equals(numberDto2.number) &&
//                        number.getPerson().equals("kein")));
    }

    @Test
    public void testGetAll_personWithoutNumbers_onePersonZeroNumbers() {
        List<Person> personList = new ArrayList<>();
        LocalDate birthday = LocalDate.now().minusYears(25);
        Person person = new Person("Vasily", "Kotov", birthday);
        personList.add(person);

        when(personRepo.findAll()).thenReturn(personList);

        List<PersonDto> result = personService.getAll();

        verify(personRepo).findAll();

        assertEquals(1, result.size());
    }

    @Test
    public void testGetAll_personsWithoutNumbers_twoPersonsZeroNumbers() {
        LocalDate birthday = LocalDate.now().minusYears(25);
        Person person1 = new Person("Vasily", "Kotov", birthday);
        Person person2 = new Person("Petr", "Petrov", birthday);
        List<Person> personList = Arrays.asList(person1, person2);

        when(personRepo.findAll()).thenReturn(personList);

        List<PersonDto> result = personService.getAll();

        verify(personRepo).findAll();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetByName_onePersonWithoutNumber_onePersonZeroNumbers(){
        LocalDate birthday = LocalDate.now().minusYears(25);
        Person person1 = new Person("Vasily", "Kotov", birthday);
        List<Person> personList = Arrays.asList(person1);

        when(personRepo.findByName("Vasily")).thenReturn(personList);

        List<PersonDto> result = personService.getByName("Vasily");

        verify(personRepo).findByName("Vasily");

        assertEquals(1, result.size());

    }

//    @Test
//    public void testGetByName_twoPersonsWithoutNumber_onePersonZeroNumbers(){
//        LocalDate birthday = LocalDate.now().minusYears(25);
//        PersonDto person1 = new PersonDto(1,"Vasily", "Kotov", birthday);
//        PersonDto person2 = new PersonDto(2,"Petr", "Kotov", birthday);
//        personService.create(person1);
//        personService.create(person2);
//
//        Person person = new Person(person1.firstName,person1.lastName,person1.birthday);
//
//        List<PersonDto> personDtoList = Arrays.asList(person1,person2);
//        List<Person> personList = Arrays.asList(person);
//
//
//        when(personRepo.findByName("Vasily")).thenReturn(personList);
//
//        List<PersonDto> result = personService.getByName("Vasily");
//
//        verify(personRepo).findByName("Vasily");
//
//        assertEquals(1, result.size());
//    }

//    @Test
//    public void testGetByName_twoPersonsWithoutNumber_twoPersonsZeroNumbers(){
//        LocalDate birthday = LocalDate.now().minusYears(25);
//        Person person2 = new Person("Petr", "Kotov", birthday);
//        Person person3 = new Person("Petr", "Petin", birthday);
//        List<Person> personList = Arrays.asList(person2,person3);
//
//        when(personRepo.findByName("Petr")).thenReturn(personList);
//
//        List<PersonDto> result = personService.getByName("Petr");
//
//        verify(personRepo).findByName("Petr");
//
//        assertEquals(2, result.size());
//    }
}