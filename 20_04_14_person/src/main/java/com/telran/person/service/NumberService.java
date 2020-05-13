package com.telran.person.service;

import com.telran.person.dto.NumberDto;
import com.telran.person.entity.Number;
import com.telran.person.entity.Person;
import com.telran.person.mapper.NumberMapper;
import com.telran.person.persistence.INumberRepo;
import com.telran.person.persistence.IPersonRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NumberService {
    final static String NUMBER_NOT_FOUND = "Number not found";

    final private INumberRepo numberRepo;
    final private IPersonRepo personRepo;
    final private NumberMapper numberMapper;

    public NumberService(INumberRepo numberRepo, IPersonRepo personRepo, NumberMapper numberMapper) {
        this.numberRepo = numberRepo;
        this.personRepo = personRepo;
        this.numberMapper = numberMapper;
    }

    public void create(NumberDto numberIn) {
        Person person = personRepo.findById(numberIn.personId).orElseThrow(() -> new EntityNotFoundException(PersonService.PERSON_NOT_FOUND));
        Number number = new Number(person, numberIn.number);
        numberRepo.save(number);
    }

//    @Transactional
    public void edit(NumberDto numberDto) {
        Number number =  numberRepo.findById(numberDto.id).orElseThrow(() -> new EntityNotFoundException((NUMBER_NOT_FOUND)));
        number.setNumber(numberDto.number);
//        numberRepo.save(number);
    }

    public void removeById(int id) {
        numberRepo.deleteById(id);
    }

    public List<NumberDto> getAllByPerson (int personId){
        List<Number> numbers = numberRepo.findByPersonId(personId);
        return numbers.stream()
                .map(numberMapper::mapNumberToDto)
                .collect(Collectors.toList());
    }

    public NumberDto getById(int id) {
        Number number = numberRepo.findById(id).orElseThrow(()->new EntityNotFoundException(NUMBER_NOT_FOUND));
        return numberMapper.mapNumberToDto(number);
    }
}
