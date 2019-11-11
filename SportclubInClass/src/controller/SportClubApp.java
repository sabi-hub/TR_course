package controller;


import dao.Group;
import dao.SportClub;
import data.*;

public class SportClubApp {

    public static void main(String[] args) {

        Customer c1 = new Customer("Vanya Ivanov", 15);
        Customer c2 = new Customer("Vasya Vasilchikov", 18);
        Customer c3 = new Customer("Vika Ivanova", 17);
        Customer c4 = new Customer("Petya Petrov", 14);
        Customer c5 = new Customer("Olya Olina", 15);
        Customer c6 = new Customer("Misha Mishin", 17);
        Customer c7 = new Customer("Masha Mashina", 18);
        Customer c8 = new Customer("Kolya Kolesnikov", 16);
        Customer c9 = new Customer("Vera Verina", 16);

        Group tennisGroup = new Group(10);
        tennisGroup.addCustomerToGroup(c1);
        tennisGroup.addCustomerToGroup(c3);
        tennisGroup.addCustomerToGroup(c5);

        Group boxGroup = new Group(10);
        boxGroup.addCustomerToGroup(c2);
        boxGroup.addCustomerToGroup(c4);
        boxGroup.addCustomerToGroup(c8);

        Group footballGroup = new Group(10);
        footballGroup.addCustomerToGroup(c6);
        footballGroup.addCustomerToGroup(c7);
        footballGroup.addCustomerToGroup(c9);

        DayOfWeek[] footballDays = {DayOfWeek.THURSDAY, DayOfWeek.WEDNESDAY};
        DayOfWeek[] boxDays = {DayOfWeek.SATURDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY};
        DayOfWeek[] tennisDays = {DayOfWeek.FRIDAY, DayOfWeek.THURSDAY};

        Section football = new Football("Jurgen Klopp", footballDays,footballGroup);
        Section tennis = new Tennis("Boris Bekker", tennisDays, tennisGroup);
        Section box = new Box("Leila Ali", boxDays,boxGroup);

        SportClub dinamo = new SportClub(5);
        dinamo.addSection(football);
        dinamo.addSection(tennis);
        dinamo.addSection(box);

        dinamo.displaySection();
        System.out.println();

        System.out.println(dinamo.getPriceBySection("tennis"));
        System.out.println();

        dinamo.displayTrainerNameBySectionName("tennis");
        System.out.println();

        dinamo.displayDayOfClassesBySectionName("tennis");

        System.out.println();
        dinamo.displayCustomersBySection("tennis");

        System.out.println();
        dinamo.addCustomerToSection("tennis", new Customer("Mariya Sharapova", 34));

        dinamo.displaySection();
        dinamo.removeCustomerFromSection("tennis", "Mariya Sharapova");

        System.out.println();
        dinamo.displaySection();

        System.out.println();
        dinamo.changeTrainerName("tennis", "Pit Sampres");
        System.out.println();

        dinamo.displaySection();
        System.out.println();





    }
}
