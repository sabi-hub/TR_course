package data;

import dao.Group;

public class Tennis extends Section {

    final double PRICE_FACTOR = 5;

    public Tennis(String trainerName, DayOfWeek[] days, Group group) {
        super(trainerName, days, group);
    }

    @Override
    public double getPrisePerHour() {
        return PRICE_FACTOR * BASIC_PRISE;
    }
}
