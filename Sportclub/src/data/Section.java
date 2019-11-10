package data;


public abstract class Section {
    private String namesection;
    private String trainer;
    private double basicprice;

    private Schedule[] in_schedule;


    public Section (String namesection, String trainer, double basicprice, Schedule[] schedule){
        this.namesection=namesection;
        this.trainer=trainer;
        this.basicprice=basicprice;
        this.in_schedule=schedule;
    }

    public String getNamesection() {
        return namesection;
    }

    public void setNamesection(String namesection) {
        this.namesection = namesection;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public double getBasicprice() {
        return basicprice;
    }

    public void setBasicprice(double basicprice) {
        this.basicprice = basicprice;
    }

    public Schedule[] getIn_schedule() {
        return in_schedule;
    }

    public void setIn_schedule(Schedule[] in_schedule) {
        this.in_schedule = in_schedule;
    }


}

