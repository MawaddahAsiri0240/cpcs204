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
public class Passenger {

    private String passengerID; // The unique identifier for the passenger
    private String name; // The name of the passenger

    // Constructor to initialize the passenger with an ID and name
    public Passenger(String passengerID, String name) {
        this.passengerID = passengerID;
        this.name = name;
    }

    // Getter method for the passenger ID
    public String getPassengerID() {
        return passengerID;
    }

    // Getter method for the passenger name
    public String getName() {
        return name;
    }

    // Overriding the toString method to provide a string representation of the passenger
    @Override
    public String toString() {
        return "Passenger{" + "passengerID=" + passengerID + ", name=" + name + '}';
    }
}
