package dao;

import data.Customer;
import data.DayOfWeek;
import data.Section;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class SportClub {

    private Section[] sections;
    private int size;

    public SportClub (int capacity){
        sections = new Section[capacity];
        size = 0;
    }

    public boolean addSection(Section section) {
        if (size < sections.length) {
            sections[size] = section;
            size++;
            return true;
        }
        return false;
    }

    public boolean removeSection (String name){
        for (int i = 0; i<size; i++){
            if (sections[i].getClass().getSimpleName().equalsIgnoreCase(name)){
                sections[i] = sections[size -1];
                size --;
                return true;
            }
        }
        return false;
    }

    public void displaySection(){
        for (int i =0; i<size; i++){
            System.out.println(sections[i]);
        }
    }

    public void displayTrainerNameBySectionName(String name){
        for (int i = 0; i<size; i++){
            if(sections[i].getClass().getSimpleName().equalsIgnoreCase(name)){
                System.out.println(sections[i].getTrainerName());
            }
        }
    }

    public void changeTrainerName(String sectionName, String trainerName){
        for (int i=0; i<size; i++){
            if (sections[i].getClass().getSimpleName().equalsIgnoreCase(sectionName)){
                sections[i].setTrainerName(trainerName);
                System.out.println(sections[i].getTrainerName());

            }
        }
    }


    public void displayDayOfClassesBySectionName (String name){
        for(int i =0; i<size; i++){
            if(sections[i].getClass().getSimpleName().equalsIgnoreCase(name)){
                System.out.println(Arrays.toString(sections[i].getDays()));
            }
        }
    }

    public double getPriceBySection(String name){
        for(int i=0; i<size; i++){
            if(sections[i].getClass().getSimpleName().equalsIgnoreCase(name)){
                return sections[i].getPrisePerHour();
            }
        }
        return -1;
    }

    public void displayCustomersBySection(String name) {
        for (int i= 0; i<size; i++){
            if (sections[i].getClass().getSimpleName().equalsIgnoreCase(name)){
                sections[i].getGroup().displayCustomersNames();
            }
        }
    }

    public boolean addCustomerToSection(String sectionName, Customer customer){
        for (int i = 0; i<size; i++){
            if (sections[i].getClass().getSimpleName().equalsIgnoreCase(sectionName)){
                if(sections[i].getGroup().addCustomerToGroup(customer))
                    sections[i].getGroup().displayCustomers();
                    return true;
            }
        }
        return false;
    }

    public  boolean removeCustomerFromSection (String sectionName, String name ){
        for(int i = 0; i<size; i++){
            if (sections[i].getClass().getSimpleName().equalsIgnoreCase(sectionName)){
                if(sections[i].getGroup().removeCustomer(name)){
                    return true;
                }
            }
        }
        return false;
    }





}
