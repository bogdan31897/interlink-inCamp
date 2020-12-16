package com.company;

public class Node<T> {

    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    } // getter date
    public void setValue(T value) {
        this.value = value;
    } // setter data
    public Node<T> getNext() {
        return next;
    } // getter next
    public void setNext(Node<T> next) {
        this.next = next;
    }


}
