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
public class Stack<T> {

    private Node<T> top; // Reference to the top of the stack

    // Constructor to initialize an empty stack
    public Stack() {
        top = null;
    }

    // Method to push a new element onto the stack
    public void push(T data) {
        top = new Node<>(data, top);
    }

    // Method to pop the top element from the stack
    public T pop() {
        if (!isEmpty()) { // Check if the stack is not empty
            T temp = top.data;
            top = top.next; // Move the top reference to the next node
            return temp;
        } else {
            return null; // Return null if the stack is empty
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Method to get the top node of the stack without removing it
    public Node<T> peek() {
        if (!isEmpty()) {
            return top;
        } else {
            return null;
        }
    }
}
