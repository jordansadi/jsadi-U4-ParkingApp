package edu.wctc.jsadi;

import java.time.LocalTime;

/**
 * This class defines a RandomTime and generates random times based on specific criteria.
 * Created by jsadi on 12/3/2018
 * @author Jordan Sadi
 * @version 2018 1203 1
 */
public class RandomTime {
    private LocalTime randTime;

    /**
     * This is the constructor for this class.
     * It generates one of three types of RandomTime based on user input, including a random checkin or checkout time.
     * A third type of RandomTime is generated if no checkout time is necessary for a given ticket.
     * @param timeType String the type of RandomType to generate.
     */
    public RandomTime(String timeType) {
        switch (timeType.toLowerCase()) {
            case "in":
                randTime = LocalTime.of(7 + (int) (Math.random() * ((12 - 7) + 1)), 0);
                break;
            case "out":
                randTime = LocalTime.of(13 + (int) (Math.random() * ((23 - 13) + 1)), 0);
                break;
            default:
                randTime = LocalTime.of(CheckIn.time, 0);
                break;
        }
    }

    /**
     * This method returns a time associated with a Check.
     * @return LocalTime the time associated with a given Check.
     */
    public LocalTime getTime() {
        if (randTime == null)
            return null;
        else
            return randTime;
    }

    /**
     * This method returns an integer of the hour associated with a Check.
     * @return int the hour associated with a given Check.
     */
    public int getHour() {
        return randTime.getHour();
    }
}
