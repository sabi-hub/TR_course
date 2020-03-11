package com.telran;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        // birthday - day of week
        DayOfWeek dayOfWeek = LocalDate.parse("1982-04-16").getDayOfWeek();
        System.out.println("Day of the week of my birthday: "+dayOfWeek);

        // birthday - day of the year
        int dayOfYear =  LocalDate.parse("1982-04-16").getDayOfYear();
        System.out.println("Day of the year of my birthday: "+dayOfYear);

        //US format of my birthday
        LocalDate myDate = LocalDate.parse("1982-04-16");
        DateTimeFormatter formatterUS = DateTimeFormatter.ofPattern("MM.dd.yy");
        System.out.println("My birthday: "+myDate.format(formatterUS));
    }
}
