package com.telran.person.controller;

import com.telran.person.dto.PersonDto;
import com.telran.person.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PersonController {

    private PersonService personService;

    @ResponseBody
    @PostMapping ("/person")
    public void createPerson(@RequestBody PersonDto personDto){
        personService.create(personDto);
    }
    @ResponseBody
    @GetMapping("/person")
    public List<PersonDto> getAll(){
        return personService.getAll();
    }
}
