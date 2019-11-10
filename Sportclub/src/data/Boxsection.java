package data;

public class Boxsection extends Section {

    public static double k=1.2;
    private double price;
    public static String namesection = "Box";

    private Schedule[] in_schedule;

    public Boxsection (String trainer, double basicprice, Schedule[] schedule){
        super(namesection,trainer,basicprice, schedule);
        this.price=basicprice*k;

        System.out.println("Box section created: trainer=" + getTrainer() + ", price ="+ this.price+ " schedule: " + getIn_schedule());

    }
}
