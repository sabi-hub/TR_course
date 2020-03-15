package com.telran;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        ZonedDateTime zStartPeter = ZonedDateTime.of(today, LocalTime.of(9,00), ZoneId.of("Europe/Moscow"));
        ZonedDateTime zEndPeter = ZonedDateTime.of(today, LocalTime.of(18,00), ZoneId.of("Europe/Moscow"));
        ZonedDateTime zStartNY = ZonedDateTime.of(today, LocalTime.of(8,00), ZoneId.of("America/New_York"));
        ZonedDateTime zEndNY = ZonedDateTime.of(today, LocalTime.of(17,00), ZoneId.of("America/New_York"));
        ZonedDateTime zStartLondon = ZonedDateTime.of(today, LocalTime.of(8,30), ZoneId.of("Europe/London"));
        ZonedDateTime zEndLondon = ZonedDateTime.of(today, LocalTime.of(17,00), ZoneId.of("Europe/London"));

        ZonedDateTime zPeterNYStart = zStartPeter.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime zPeterNYEnd = zEndPeter.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime zNYPeterStart = zStartNY.withZoneSameInstant(ZoneId.of("Europe/Moscow"));
        ZonedDateTime zNYPeterEnd = zEndNY.withZoneSameInstant(ZoneId.of("Europe/Moscow"));

        System.out.println("Start of working day in Petersburg by NY zone: " +zPeterNYStart);
        System.out.println("The End of working day in Petersburg by NY zone: " +zPeterNYEnd);
        System.out.println("Start of working day in NY by Petersburg zone: " +zNYPeterStart);
        System.out.println("The End of working day in NY by Petersburg zone: " +zNYPeterEnd);
        System.out.println();
        long timeForMeetingPeterNY = zNYPeterStart.until(zEndPeter, ChronoUnit.HOURS);
        System.out.println("Intersection of NY and Petersburg hours: " +timeForMeetingPeterNY);
        System.out.println();
        System.out.println("**********");

        ZonedDateTime zLondonNYStart = zStartLondon.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime zLondonNYEnd = zEndLondon.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime zNYLondonStart = zStartNY.withZoneSameInstant(ZoneId.of("Europe/London"));
        ZonedDateTime zNYLondonEnd = zEndNY.withZoneSameInstant(ZoneId.of("Europe/London"));

        System.out.println("Start of working day in London by NY zone: "+zLondonNYStart);
        System.out.println("The End of working day in London by NY zone: " +zLondonNYEnd);
        System.out.println("Start of working day in NY by London zone: " +zNYLondonStart);
        System.out.println("The End of working day in NY by London zone: " +zNYLondonEnd);
        System.out.println();
        long timeForMeetingLondonNY = zNYLondonStart.until(zEndLondon, ChronoUnit.HOURS);
        System.out.println("Intersection of NY and London hours: " +timeForMeetingLondonNY);
    }
}
