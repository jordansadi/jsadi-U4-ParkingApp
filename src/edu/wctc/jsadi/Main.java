package edu.wctc.jsadi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the driver class for this package.
 * It reads a file of tickets into an ArrayList, then runs the parking garage menu.
 * Users can park in the garage, pay for a ticket, special event, or lost ticket, and close the garage.
 * Any new tickets are added to the ArrayList.
 * When the garage is closed, it writes the ArrayList to the file and summarized the totals of payments made.
 * Created by jsadi on 9/29/2018
 * @author Jordan Sadi
 * @version 2018 1203 2
 */
public class Main {

    public static void main(String[] args) {
        CheckInOutFactory checkFactory = new CheckInOutFactory();
        boolean runMenu = true, keepGoing;
        int userInput;
        Scanner k = new Scanner(System.in);
        ArrayList<CheckIn> tickets = new ArrayList<>();
        FileInput inFile = FileInput.getFileInput("parkingTickets.txt");
        String lineIn;
        String[] lines;

        while ((lineIn = inFile.fileReadLine()) != null) {
            CheckIn newUser = (CheckIn)checkFactory.getCheck(CheckType.CHECKIN);
            lines = lineIn.split(",");
            newUser.amountDue = Double.parseDouble(lines[0]);
            CheckIn.time = Integer.parseInt(lines[1].substring(0, 2));
            newUser.setCheckIn("");
            try {
                CheckIn.time = Integer.parseInt(lines[2].substring(0, 2));
                newUser.setCheckOut("");
            } catch (Exception e) {
                newUser.setCheckOut("LocalTime.of(23, 0)");
            }
            newUser.hoursParked = Integer.parseInt(lines[3]);
            newUser.vehicleID = Integer.parseInt(lines[4]);
            tickets.add(newUser);
        }

        while (runMenu) {
            CheckIn newUser = (CheckIn)checkFactory.getCheck(CheckType.CHECKIN);

            if (tickets.size() > 0)
                newUser.vehicleID = tickets.get(tickets.size() - 1).vehicleID + 1;

            keepGoing = true;
            userInput = 0;
            newUser.menu();
            try {
                userInput = k.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input");
                k.next();
            }

            if (userInput == 3) {
                runMenu = false;

                for (CheckIn c : tickets)
                    CheckOut.total += c.amountDue;

                CheckOut.summary();
                FileOutput outFile = FileOutput.getFileOutput("parkingTickets.txt");
                for (CheckIn c : tickets) {
                    outFile.fileWrite(c.amountDue + ","
                            + c.checkIn.getTime() + ","
                            + c.checkOut.getTime() + ","
                            + c.hoursParked + "," + c.vehicleID);
                }
                inFile.fileClose();
                outFile.fileClose();
            }

            else if (userInput == 2) {
                CheckOut userCheckout = (CheckOut)checkFactory.getCheck(CheckType.CHECKOUT);
                userCheckout.setCheckIn(newUser);

                while(keepGoing) {
                    userCheckout.menu();
                    userInput = 0;
                    try {
                        userInput = k.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                        k.next();
                    }

                    if (userInput == 2) {
                        userCheckout.lostTicket(new LostTicket().getCost());
                        keepGoing = false;
                    }
                    else if  (userInput == 1) {
                        userCheckout.setEvent(true);
                        userCheckout.userCheckout();
                        keepGoing = false;
                    }
                }
                userCheckout.receipt();
                tickets.add(newUser);
            }

            else if (userInput == 1) {
                CheckOut userCheckout = (CheckOut)checkFactory.getCheck(CheckType.CHECKOUT);
                userCheckout.setCheckIn(newUser);

                while(keepGoing) {
                    userCheckout.menu();
                    userInput = 0;
                    try {
                        userInput = k.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                        k.next();
                    }

                    if (userInput == 2) {
                        userCheckout.lostTicket(new LostTicket().getCost());
                        keepGoing = false;
                    }
                    else if  (userInput == 1) {
                        userCheckout.userCheckout();
                        keepGoing = false;
                    }
                }
                userCheckout.receipt();
                tickets.add(newUser);
            }
        }
    }
}