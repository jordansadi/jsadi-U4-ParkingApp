package edu.wctc.jsadi;

/**
 * This class controls the CheckOut process for each customer of the parking garage.
 * It tracks the charges for each customer, as well as the total charges for each session.
 * It also runs the checkout menu, which allows users to pay for their ticket or a lost ticket.
 * Created by jsadi on 9/29/2018
 * @author Jordan Sadi
 * @version 2018 1203 2
 */
public class CheckOut implements Check {
    private CheckIn userCheckin;
    private static double checkinTotal = 0, lostTicketTotal = 0, specialEventTotal = 0;
    static double total = 0;
    private static int checkins = 0, lostTickets = 0, specialEvents = 0;
    private boolean event = false;

    /**
     * This is the constructor for this class.
     */
    public CheckOut(){}

    /**
     * This method sets the CheckIn that a CheckOut is related to.
     * @param userCheckIn CheckIn the CheckIn that a given CheckOut is related to.
     */
    public void setCheckIn(CheckIn userCheckIn) {
        this.userCheckin = userCheckIn;
    }

    /**
     * This method runs the checkout menu, which allows customers to pay for their ticket or for a lost ticket.
     */
    public void menu() {
        System.out.println("\nBest Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1 - Check/Out");
        System.out.println("2 - Lost Ticket");
        System.out.print("=>_");
    }

    /**
     * This method assesses the charges for a lost ticket.
     * It also increments the lostTickets variable, to track the total number of lost tickets for a given session.
     * @param amountDue double the amount a customer will be charged for a lost ticket
     */
    public void lostTicket(double amountDue) {
        userCheckin.amountDue = amountDue;
        CheckIn.time = 0;
        userCheckin.setCheckOut("");
        lostTicketTotal += userCheckin.amountDue;
        lostTickets++;
    }

    /**
     * This method sets whether a ticket is for a special event.
     * @param event boolean whether a ticket is for a special event.
     */
    public void setEvent(boolean event) {
        this.event = event;
    }

    /**
     * This method creates a random checkout time, then assesses the charges based on how long the user parked.
     * The method accounts for whether a ticket was for a special event and charges accordingly.
     * It also increments the checkins variable, to track the total number of checkins for a given session.
     */
    public void userCheckout() {
        if (!event) {
            CheckIn.time = 13 + (int)(Math.random() * ((23 - 13) + 1));
            userCheckin.setCheckOut("");
            userCheckin.hoursParked = userCheckin.checkOut.getHour() - userCheckin.checkIn.getHour();

            userCheckin.amountDue = new StandardCheckout(userCheckin.hoursParked).getCost();

            checkinTotal += userCheckin.amountDue;
            checkins++;
        }
        else {
            userCheckin.amountDue = new SpecialEvent().getCost();
            CheckIn.time = 0;
            userCheckin.setCheckOut("");
            specialEventTotal += userCheckin.amountDue;
            specialEvents++;
            event = false;
        }
    }

    /**
     * This method prints the receipt for a user.
     * If the ticket was lost or for a special event, that information is printed.
     * If the ticket was a standard ticket, the amount of time parked is printed along with the checkin and checkout times.
     * It then prints the total amount due for that customer.
     */
    public void receipt() {
        String checkInPrint, checkOutPrint;
        LostTicket lt = new LostTicket();
        SpecialEvent se = new SpecialEvent();

        System.out.println("\nBest Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Receipt for a vehicle id " + userCheckin.vehicleID);

        if (userCheckin.amountDue == lt.getCost())
            System.out.println("\nLost Ticket");
        else if (userCheckin.amountDue == se.getCost())
            System.out.println("\nSpecial Event");
        else {
            if (userCheckin.checkIn.getHour() < 12)
                checkInPrint = userCheckin.checkIn.getHour() + "am";
            else
                checkInPrint = userCheckin.checkIn.getHour() + "pm";

            checkOutPrint = (userCheckin.checkOut.getHour() - 12) + "pm";
            System.out.println("\n" + userCheckin.hoursParked + " hours parked " + checkInPrint + " - " + checkOutPrint);
        }

        System.out.printf("$%.2f\n", userCheckin.amountDue);
    }

    /**
     * This method prints a summary of all transactions for a given session, and the total lifetime charges for the garage.
     * The total amounts of checkins, special events, and lost tickets for the session are printed.
     * The total amount charged for checkins, special events, and lost tickets in the session is also printed.
     */
    public static void summary() {
        System.out.println("\nBest Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Activity to Date\n");
        System.out.printf("$%.0f was collected from " + checkins + " Check Ins\n", checkinTotal);
        System.out.printf("$%.0f was collected from " + specialEvents + " Special Events\n", specialEventTotal);
        System.out.printf("$%.0f was collected from " + lostTickets + " Lost Tickets\n", lostTicketTotal);
        System.out.printf("\n$%.0f was collected overall", total);
    }
}
