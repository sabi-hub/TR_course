package data;

public class Tennissection extends Section{

    public static double k=1.8;
    private double price;
    public static String namesection = "Tennis";

    private Schedule[] in_schedule;

    public Tennissection (String trainer, double basicprice, Schedule[] schedule){
        super(namesection,trainer,basicprice, schedule);
        this.price=basicprice*k;

        System.out.println("Tennis section created: trainer=" + getTrainer() + ", price ="+ this.price+ " schedule: " + getIn_schedule());

    }
}
