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
public class Queue<T> {

    private Node<T> front; // Front node of the queue
    private Node<T> rear; // Rear node of the queue

    // Constructor to initialize an empty queue
    public Queue() {
        front = null;
        rear = null;
    }

    // Method to add an element to the rear of the queue
    public void enqueue(T data) {
        if (front == null) { // If the queue is empty
            front = new Node<>(data, front);
            rear = front;
        } else { // If the queue is not empty
            rear.next = new Node<>(data, null);
            rear = rear.next;
        }
    }

    // Method to remove an element from the front of the queue
    public T dequeue() {
        if (!isEmpty()) { // If the queue is not empty
            T value = front.data;
            if (front.next == null) { // If there is only one element in the queue
                front = null;
                rear = null;
            } else { // If there are more elements in the queue
                front = front.next;
            }
            return value;
        } else {
            return null; // If the queue is empty
        }
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to get the front node of the queue without removing it
    public Node<T> peek() {
        if (!isEmpty()) {
            return front;
        } else {
            return null;
        }
    }
}
