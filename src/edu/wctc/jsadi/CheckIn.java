package edu.wctc.jsadi;

/**
 * This class creates the ticket for each customer and tracks all relevant information.
 * It also runs the initial menu for the parking garage.
 * Created by jsadi on 9/29/2018
 * @author Jordan Sadi
 * @version 2018 1203 2
 */
public class CheckIn implements Check {
    RandomTime checkIn, checkOut;
    int hoursParked;
    static int time;
    int vehicleID = 100;
    double amountDue = 5.00;

    /**
     * This is the constructor for the CheckIn class.
     * Each CheckIn is initialized with a random time, which could easily be replaced with the current time.
     * Each CheckIn causes the vehicleID (which is based on the last vehicleID read from the file) to increment).
     */
    public CheckIn(){
        checkIn = new RandomTime("in");
        vehicleID++;
    }

    /**
     * This method sets the check-in time to a new RandomTime
     * @param in String the type of RandomTime to set the check-in time to
     */
    public void setCheckIn(String in) {
        checkIn = new RandomTime(in);
    }

    /**
     * This method sets the check-out time to a new RandomTime
     * @param out String the type of RandomTime to set the check-out time to
     */
    public void setCheckOut(String out) {
        checkOut = new RandomTime(out);
    }

    /**
     * This method prints the main menu for the parking garage, then waits for user input.
     */
    public void menu() {
        System.out.println("\nBest Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1 - Check/In");
        System.out.println("2 - Special Event");
        System.out.println("3 - Close Garage");
        System.out.print("=>_");
    }
}
