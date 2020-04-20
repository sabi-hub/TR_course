package com.telran.person.validation.annotation;

import com.telran.person.dto.PersonDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class MoreThanYearsValidator implements ConstraintValidator<MoreThanYears, PersonDto> {

   int minYears;

   public void initialize(MoreThanYears constraint) {
      minYears = constraint.value();
   }

   public boolean isValid(PersonDto value, ConstraintValidatorContext context) {
      LocalDate now = LocalDate.now();
      return now.minusYears(value.birthday.getYear()).getYear() >minYears;
   }
}


