package edu.wctc.jsadi;

/**
 * This class defines a LostTicket and implements the PriceType interface.
 * Created by jsadi on 12/3/2018
 * @author Jordan Sadi
 * @version 2018 1203 1
 */
public class LostTicket implements PriceType {
    private double cost = 25.00;

    /**
     * This method returns the cost of a LostTicket.
     * @return double the cost of a LostTicket.
     */
    public double getCost() {
        return cost;
    }
}
