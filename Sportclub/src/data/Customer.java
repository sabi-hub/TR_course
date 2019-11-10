package data;

import data.Section;

import java.util.Scanner;

public class Customer {

    private String customername;
    private int customerage;
    private Section customersection;

    public Customer (String customername, int customerage, Section customersection){
        this.customername=customername;
        this.customerage=customerage;
        this.customersection = customersection;

        System.out.println("Customer name: "+getCustomername()+", age: "+getCustomerage()+", section: "+getCustomersection().getNamesection());

        }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public int getCustomerage() {
        return customerage;
    }

    public void setCustomerage(int customerage) {
        this.customerage = customerage;
    }

    public Section getCustomersection() {
        return customersection;
    }

    public void setCustomersection(Section customersection) {
        this.customersection = customersection;
    }




}
