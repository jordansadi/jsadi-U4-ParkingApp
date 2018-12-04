package edu.wctc.jsadi;

/**
 * This class defines a StandardCheckout and implements the PriceType interface.
 * Created by jsadi on 12/3/2018
 * @author Jordan Sadi
 * @version 2018 1203 1
 */
public class StandardCheckout implements PriceType {
    private int hoursParked;
    private double cost = 5.00;

    /**
     * This constructor defines a StandardCheckout for a specified number of hours.
     * @param hoursParked int the number of hours parked.
     */
    public StandardCheckout(int hoursParked) {
        this.hoursParked = hoursParked;
    }

    /**
     * This method returns the cost of a StandardCheckout based on the number of hours parked.
     * @return double the cost of the StandardCheckout.
     */
    public double getCost() {
        if (hoursParked > 3 && hoursParked <= 13) {
            cost += (hoursParked - 3);
        }
        else if (hoursParked > 13) {
            cost = 15.00;
        }

        return cost;
    }
}
