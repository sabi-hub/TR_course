package data;

import data.Schedule;

public class Footballsection extends Section {

    public static double k=1.5;
    private double price;
    public static String namesection = "Football";


    public Footballsection (String trainer, double basicprice, Schedule[] schedule){
        super(namesection,trainer,basicprice, schedule);
        this.price=basicprice*k;

        System.out.println("Football section created: trainer=" + getTrainer() + ", price ="+ this.price+ " schedule: " + getIn_schedule()[0].toString());
    }


}
