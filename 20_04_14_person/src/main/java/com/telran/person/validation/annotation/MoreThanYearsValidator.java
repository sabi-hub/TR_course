package com.telran.person.validation.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class MoreThanYearsValidator implements ConstraintValidator<MoreThanYears, LocalDate> {

   int minAge;

   public void initialize(MoreThanYears constraint) {
      minAge = constraint.value();
   }

   @Override
   public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
//      LocalDate now = LocalDate.now();
//      return now.minusYears(value.getYear()).getYear() > minAge;

      LocalDate latestBirthday = LocalDate.now().minusYears(minAge);
      return !value.isAfter(latestBirthday);
   }

}


