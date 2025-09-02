/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t07_2306042_p3;

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
public class Train {

    private String trainID; // Identifier for the train
    private int capacity; // Total capacity of the train
    private int availableSeats; // Currently available seats on the train

    // Constructor to initialize the train with an ID and capacity
    public Train(String trainID, int capacity) {
        this.trainID = trainID;
        this.capacity = capacity;
        this.availableSeats = capacity; // Initially, all seats are available
    }

    // Getter method for the train ID
    public String getTrainID() {
        return trainID;
    }

    // Method to book a seat for a passenger
    public String bookSeat(Passenger passenger) {
        if (availableSeats > 0) { // Check if seats are available
            availableSeats--; // Decrement the count of available seats
            return "Booking confirmed for Passenger " + passenger.getName() + " (ID: " + passenger.getPassengerID() + ").";
        } else { // If no seats are available
            return "No seats for " + passenger.getName() + " (ID: " + passenger.getPassengerID() + "), added to waiting list.";
        }
    }

    // Method to cancel a seat booking for a passenger
    public String cancelSeat(Passenger passenger) {
        availableSeats++; // Increment the count of available seats
        return "Booking cancelled for Passenger " + passenger.getName() + " (ID: " + passenger.getPassengerID() + ").";
    }
}
