package com.company;

public class Node {
    private int value;
    private Node next;


    Node(int value) {
        this.value = value;
    }
    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public void Next(Node next) {
        this.next = next;
    }
    public int getValue() {
        return value;
    }


}
