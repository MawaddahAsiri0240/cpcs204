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
public class Node<T> {
    protected T data; // The data stored in the node
    protected Node<T> next; // The reference to the next node in the list

    // Constructor to initialize the node with data
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    // Constructor to initialize the node with data and the reference to the next node
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}