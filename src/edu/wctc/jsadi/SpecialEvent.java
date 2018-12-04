package edu.wctc.jsadi;

/**
 * This class defines a SpecialEvent and implements the PriceType interface.
 * Created by jsadi on 12/3/2018
 * @author Jordan Sadi
 * @version 2018 1203 1
 */
public class SpecialEvent implements PriceType {
    private double cost = 20.00;

    /**
     * This method returns the cost of a SpecialEvent.
     * @return double the cost of a SpecialEvent.
     */
    public double getCost() {
        return cost;
    }
}