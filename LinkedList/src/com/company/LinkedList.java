package com.company;

import java.util.function.Consumer;

public class LinkedList {

    private Node head;
    private int length;

    public int getLength() {
        return length;
    }

    LinkedList() {
        this.head = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return this.getLength() == 0;
    }

    public void insert(int value) {
        head = new Node(value, head);
        length++;
    }

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        getTail().setNext(new Node(data));
        length++;
    }

    private Node getTail() {
        Node tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        return tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Node item = this.head; item != null; item = item.getNext()) {
            sb.append(item.getValue()).append(" ");
        }

        return sb.toString();
    }

    public void forEach(Consumer<Integer> consumer) {
        for (Node node = head; node != null; node = node.getNext()) {
            consumer.accept(node.getValue());
        }
    }

    public int getItem(int i) {
        int startId = 0;
        for (Node item = this.head; item != null; item = item.getNext()) {
            if (startId == i) return item.getValue();
            startId++;
        }
        return 0;
    }

    public void remove(int position) {
        // If linked list is empty
        if (this.head == null)
            return;

        // Store head node
        Node temp = this.head;

        // If head needs to be removed
        if (position == 0) {
            this.head = temp.getNext();   // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.getNext();

        // If position is more than number of nodes
        if (temp == null || temp.getNext() == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.getNext().getNext();

        temp.Next(next);
    }
}