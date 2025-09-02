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
/**
 *
 * @author macbookair
 */
/* 
Course: CPCS 204 
Name:  Mawaddah Asiri
University ID: 2306042 
Section:  T07
Name of lab instructor: SMAHEER ALGHAMDI 
Assignment number:  #3
 */
public class Ticket {

    private Passenger passenger; // The passenger for whom the ticket is issued
    private Train train; // The train associated with the ticket

    // Constructor to initialize the ticket with a passenger and train
    public Ticket(Passenger passenger, Train train) {
        this.passenger = passenger;
        this.train = train;
    }

    // Getter method for the passenger
    public Passenger getPassenger() {
        return passenger;
    }

    // Getter method for the train
    public Train getTrain() {
        return train;
    }

    // Overriding the toString method to provide a string representation of the ticket
    @Override
    public String toString() {
        return "Ticket{" + "passenger=" + passenger + ", train=" + train + '}';
    }
}
