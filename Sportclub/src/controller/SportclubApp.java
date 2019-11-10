package controller;

import data.Section;
import data.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SportclubApp {

    public static double basicprice = 20;

    public static void main(String[] args) {

        Schedule[] FootballSchedule = {Schedule.MONDAY, Schedule.WEDNESDAY};
        Schedule[] BoxSchedule = {Schedule.TUESDAY, Schedule.FRIDAY};
        Schedule[] TennisSchedule = {Schedule.THURSDAY, Schedule.SATURDAY};

        Footballsection FS = new Footballsection("Ivan Ivanov", basicprice, FootballSchedule);
        Boxsection BS = new Boxsection("Petr Petrov", basicprice, BoxSchedule);
        Tennissection TS = new Tennissection("Semen Semenov", basicprice, TennisSchedule);

        Customer customer1 = new Customer("Ivan Petrov", 12, FS);
        Customer customer2 = new Customer("Petr Ivanov", 13, FS);
        Customer customer3 = new Customer("Fedor Semenov", 12, FS);

        Customer[] fscustomer={customer1,customer2,customer3};

    }

    private static void setNamesection(String nextLine) {
        Scanner EnterSection = new Scanner(System.in);
        System.out.println("Enter name of the section:");

        String setNamesection=EnterSection.nextLine();
        if (setNamesection == "Football") {
            System.out.println(Customer[].fscustomer());
        }
    }


}
