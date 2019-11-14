package data;

<<<<<<< HEAD

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

=======
import dao.Group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Section {

    final double BASIC_PRISE = 9.5;
    private String trainerName;
    private DayOfWeek[] days;
    private Group group;

    public Section(String trainerName, DayOfWeek[] days, Group group) {
        this.trainerName = trainerName;
        this.days = days;
        this.group = group;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public DayOfWeek[] getDays() {
        return days;
    }

    public void setDays(DayOfWeek[] days) {
        this.days = days;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        List<Customer> clearGroup = new ArrayList<Customer>();
        for(Customer customer: group.getGroup()){
            if(customer!=null) {
                clearGroup.add(customer);
            }
        }
        return this.getClass().getSimpleName() + " " +
                "Trainer: " + trainerName + '\'' +
                ", classes on" + Arrays.toString(days) +
                ", in the section: " + clearGroup;
    }

    public abstract double getPrisePerHour();



}
>>>>>>> master
