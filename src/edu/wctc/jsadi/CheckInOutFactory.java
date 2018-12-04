package edu.wctc.jsadi;

/**
 * This class defines a factory that creates instances of the CheckIn and CheckOut classes
 * Created by jsadi on 12/3/2018
 * @author Jordan Sadi
 * @version 2018 1203 1
 */
public class CheckInOutFactory {
    /**
     * This method creates an instance of a Check based on user input
     * @param check CheckType the type of Check to instantiate
     * @return Check an instance of a Check class
     */
    public Check getCheck(CheckType check) {
        switch (check) {
            case CHECKIN: return new CheckIn();
            case CHECKOUT: return new CheckOut();
            default: return null;
        }
    }
}