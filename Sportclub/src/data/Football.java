package data;

import dao.Group;

public class Football extends Section{

    final double PRICE_FACTOR = 0.5;

    public Football(String trainerName, DayOfWeek[] days, Group group) {
        super(trainerName, days, group);
    }

    @Override
    public double getPrisePerHour() {
        return PRICE_FACTOR * BASIC_PRISE;
    }
}
