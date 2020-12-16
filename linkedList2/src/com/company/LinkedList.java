package com.company;

import java.util.function.Consumer;

public class LinkedList<T> {

    private Node<T> head;


    //methods filling list
    public void insert(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(this.head);
        this.head = newNode;
    }
    public void insertAfter(int index, T value) {
        if(index > getLength()) return;
        Node<T> prev = getNode(index);
        if (prev == null) {
            System.out.println("Cant insert after tail!");
            return;
        }

        Node<T> newNode = new Node<>(value);
        newNode.setNext(prev.getNext());
        prev.setNext(newNode);
    }
    public void append(T value) {
        Node<T> newNode = new Node<>(value);
        if (this.head == null)
        {
            this.head = new Node<>(value);
            return;
        }
        newNode.setNext(null);
        Node<T> last = getLast();
        last.setNext(newNode);
    }

    //methods changes nodes
    public void removeAt(int index) {
        if(index > getLength()) return;
        if (index == 0) {
            this.head = this.head.getNext();
            return;
        }else {
            Node<T> previous = getNode(index -1);
            previous.setNext(getNode(index).getNext());

        }
    }
    public void replaceAt(int index, T value) {
        if(index > getLength()) return;
        Node<T> replaced = getNode(index);
        replaced.setValue(value);
    }

    //gets nodes
    private Node<T> getLast() {
        Node<T> last = this.head;
        while (last.getNext() != null)
            last = last.getNext();
        return last;
    }
    private Node<T> getNode(int index) {
        int id = 0;
        Node<T> temp = this.head;
        while(id != index) {
            temp = temp.getNext();
            id++;
        }
        return  temp;
    }

    //get values
    public T getItem(int index) {
        return getNode(index).getValue();

    }
    public int getLength() {
        int length = 0;
        for (Node<T> item = this.head; item != null; item = item.getNext()) {
            length++;
        }
        return length;
    }

    //isEmpty methods
    public boolean isEmpty() {
        return getLength() == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Node<T> item = this.head; item != null; item = item.getNext()) {
            stringBuilder.append(item.getValue()).append(" ");
        }
        return stringBuilder.toString();
    }
    public void forEach(Consumer<T> consumer) {
        for (Node<T> node = head; node != null; node = node.getNext()) {
            consumer.accept(node.getValue());
        }
    }
}
