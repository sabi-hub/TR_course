package data;

import dao.Group;

public class Box extends Section{

    final double PRISE_FACTOR = 2.5;

    public Box(String trainerName, DayOfWeek[] days, Group group) {
        super(trainerName, days, group);
    }

    @Override
    public double getPrisePerHour() {
        return PRISE_FACTOR * BASIC_PRISE;
    }


}
