/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t07_2306042_p3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author mawadah
 */
/* 
Course: CPCS 204 
Name:  Mawaddah Asiri
University ID: 2306042 
Section:  T07
Name of lab instructor: SMAHEER ALGHAMDI 
Assignment number:  #3
 */
public class TrainTicketBookingSystem {

    private static Queue<Passenger> passengerQueue;
    private static Stack<Ticket> confirmedStack;
    private static Queue<Ticket> waitingQueue;
    private static Train train;
    private static PrintWriter outputWriter;

    // Adds a train with the specified ID and capacity
    public static void addTrain(String trainID, int capacity) {
        train = new Train(trainID, capacity);
        outputWriter.println("Train " + trainID + " with capacity " + capacity + " has been added.");
    }

    // Adds a passenger to the queue
    public static void addPassenger(String passengerID, String name) {
        Passenger passenger = new Passenger(passengerID, name);
        passengerQueue.enqueue(passenger);
        outputWriter.println("Passenger " + name + " (ID: " + passengerID + ") has been added to the system.");
    }

    // Books a seat for the specified passenger
    public static void bookSeat(String passengerID) {
        Passenger passenger = findPassengerById(passengerID);
        String str = train.bookSeat(passenger);
        Ticket ticket = new Ticket(passenger, train);

        if (str.contains("confirmed")) {
            confirmedStack.push(ticket);
        } else {
            waitingQueue.enqueue(ticket);
        }

        outputWriter.println(str);
    }

    // Cancels the booking for the specified passenger
    public static void cancelBooking(String passengerID) {
        Passenger passenger = findPassengerById(passengerID);
        Ticket ticket = removePassengerFromConfirmed(passenger);
        String str = train.cancelSeat(ticket.getPassenger());
        outputWriter.println(str);

        if (!waitingQueue.isEmpty()) {
            Ticket nextTicket = waitingQueue.dequeue();
            confirmedStack.push(nextTicket);
            str = train.bookSeat(nextTicket.getPassenger());
            outputWriter.println(str);
        }
    }

    // Shows the list of confirmed passengers
    public static void showConfirmedTickets() {

        outputWriter.println("------------------CONFIRMED PASSENGER------------------");
        outputWriter.println("| Passenger ID    | Name            | Train ID        |");
        outputWriter.println("| --------------- | --------------- | --------------- |");

        Stack<Ticket> tempStack = new Stack<>();

        while (!confirmedStack.isEmpty()) {

            Ticket ticket = confirmedStack.pop();
            outputWriter.printf("| %-16s", ticket.getPassenger().getPassengerID());
            outputWriter.printf("| %-16s", ticket.getPassenger().getName());
            outputWriter.printf("| %-16s", ticket.getTrain().getTrainID());
            outputWriter.println("|");

            tempStack.push(ticket);
        }

        while (!tempStack.isEmpty()) {
            Ticket value = tempStack.pop();
            confirmedStack.push(value);
        }

    }
    // Shows the list of waiting passengers

    public static void showWaitingTickets() {

        outputWriter.println("------------------WAITING PASSENGER--------------------");
        outputWriter.println("| Passenger ID    | Name            | Train ID        |");
        outputWriter.println("| --------------- | --------------- | --------------- |");

        Queue<Ticket> tempQueue = new Queue<>();

        while (!waitingQueue.isEmpty()) {

            Ticket ticket = waitingQueue.dequeue();

            outputWriter.printf("| %-16s", ticket.getPassenger().getPassengerID());
            outputWriter.printf("| %-16s", ticket.getPassenger().getName());
            outputWriter.printf("| %-16s", ticket.getTrain().getTrainID());
            outputWriter.println("|");

            tempQueue.enqueue(ticket);
        }

        while (!tempQueue.isEmpty()) {
            Ticket ticket = tempQueue.dequeue();
            waitingQueue.enqueue(ticket);
        }

    }

    // Finds and returns the passenger with the specified ID
    public static Passenger findPassengerById(String passengerID) {
        Queue<Passenger> tempQueue = new Queue<>();
        Passenger passenger = null;

        while (!passengerQueue.isEmpty()) {
            Passenger currentPassenger = passengerQueue.dequeue();
            if (currentPassenger.getPassengerID().equals(passengerID)) {
                passenger = currentPassenger;
            }
            tempQueue.enqueue(currentPassenger);
        }

        while (!tempQueue.isEmpty()) {
            passengerQueue.enqueue(tempQueue.dequeue());
        }

        return passenger;
    }

    // Removes and returns the specified passenger's ticket from the confirmed stack
    public static Ticket removePassengerFromConfirmed(Passenger passenger) {
        Stack<Ticket> tempStack = new Stack<>();
        Ticket ticket = null;

        while (!confirmedStack.isEmpty()) {
            Ticket currentTicket = confirmedStack.pop();
            if (currentTicket.getPassenger().getPassengerID().equals(passenger.getPassengerID())) {
                ticket = currentTicket;
                continue;
            }
            tempStack.push(currentTicket);
        }

        while (!tempStack.isEmpty()) {
            confirmedStack.push(tempStack.pop());
        }

        return ticket;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        Scanner input = new Scanner(inputFile);
        outputWriter = new PrintWriter(outputFile);

        // Initialize data structures
        passengerQueue = new Queue<>();
        confirmedStack = new Stack<>();
        waitingQueue = new Queue<>();

        // Read commands from the input file
        while (input.hasNext()) {
            String command = input.next();
            switch (command) {
                case "add_train":
                    String trainID = input.next();
                    int capacity = input.nextInt();
                    addTrain(trainID, capacity);
                    break;
                case "add_passenger":
                    String passengerID = input.next();
                    String passengerName = input.next();
                    addPassenger(passengerID, passengerName);
                    break;
                case "book":
                    passengerID = input.next();
                    trainID = input.next();
                    bookSeat(passengerID);
                    break;
                case "cancel":
                    passengerID = input.next();
                    trainID = input.next();
                    cancelBooking(passengerID);
                    break;
                case "show_waiting":
                    showWaitingTickets();
                    break;
                case "show_confirmed":
                    showConfirmedTickets();
                    break;
                default:
                    outputWriter.println("Unknown command: " + command);
                    break;
            }
        }

        input.close();
        outputWriter.close();
    }

}
