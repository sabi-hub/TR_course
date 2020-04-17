package com.telran.person.controller;

import com.telran.person.dto.PersonDto;
import com.telran.person.service.PersonService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public void create(@RequestBody @Valid PersonDto personDto) {
        personService.create(personDto);
    }

    @PutMapping("/person")
    public void edit(@RequestBody @Valid PersonDto personDTO) {
        personService.edit(personDTO);
    }

    @GetMapping("/person")
    public List<PersonDto> getAll() {
        return personService.getAll();
    }

    @GetMapping("/person/{id}")
    public PersonDto getById(@PathVariable @Min(1) int id) {
        return personService.getById(id);
    }

    @DeleteMapping("/person/{id}")
    public void remove(@PathVariable int id) {
        personService.removeById(id);
    }

    @GetMapping("/person/name/{name}")
    public List<PersonDto> getByName(@PathVariable(value = "name") String firstName) {
        return personService.getByName(firstName);
    }

    @GetMapping("/person/age")
    public List<PersonDto> filterByAge(@RequestParam(defaultValue = "0") int min,
                                       @RequestParam(defaultValue = "" + Integer.MAX_VALUE) int max) {
        return personService.filterByAge(min, max);
    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public List<ViolationDto> handleMethodExceptions(MethodArgumentNotValidException e) {
//        return e.getBindingResult().getAllErrors().stream()
//                .map(error -> new ViolationDto(((FieldError) error).getField(), error.getDefaultMessage()))
//                .collect(Collectors.toList());
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<List<ViolationDto>> handleMethodExceptions(MethodArgumentNotValidException e) {
//        List<ViolationDto> body = e.getBindingResult().getAllErrors().stream()
//                .map(error -> new ViolationDto(((FieldError) error).getField(), error.getDefaultMessage()))
//                .collect(Collectors.toList());
//        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//    }

}
