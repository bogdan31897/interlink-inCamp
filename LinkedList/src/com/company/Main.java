package com.company;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();


        list.insert(1);
        list.append(1);


        System.out.println(list.toString());
        list.remove(3);
        System.out.println(list.toString());

    }
}
