package com.telran.person.service;

import com.telran.person.dto.PersonDto;
import com.telran.person.mapper.NumberMapper;
import com.telran.person.mapper.PersonMapper;
import com.telran.person.persistence.INumberRepo;
import com.telran.person.persistence.IPersonRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

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

    @Test
    public void testCreate_personWithoutNumbersWith_success() {
        LocalDate birthday = LocalDate.now().minusYears(25);
        PersonDto personDto = new PersonDto(5, "Vasily", "Kotov", birthday);

        personService.create(personDto);

        verify(personRepo).save(argThat(
                person -> person.getName().equals(personDto.firstName) &&
                        person.getLastName().equals(personDto.lastName) &&
                        person.getBirthday().equals(personDto.birthday)));
    }
}