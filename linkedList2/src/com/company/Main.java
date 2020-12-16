package com.company;


public class Main {

    public static void main(String[] args) {

        int stringLength = 10;
        LinkedList<String> list =  new LinkedList<>();

        list.append("3");
        list.append("1");

        list.insert("6");
        list.insert("9");

        System.out.printf("list: %s%s| Default list\n", list.toString()," ".repeat(15-list.getLength()*2));

        list.insertAfter(2, "5");
        System.out.printf("list: %s%s| Insert 5 after 3\n", list.toString()," ".repeat(15-list.getLength()*2));

        list.removeAt(0);
        System.out.printf("list: %s%s| Removed 9\n", list.toString()," ".repeat(15-list.getLength()*2));


        list.replaceAt(0, "7");
        System.out.printf("list: %s%s| Replaced 9 into 7\n", list.toString()," ".repeat(15-list.getLength()*2));


        System.out.printf("list: %s%s| Get element\n", list.getItem(2)," ".repeat(15-list.getLength()*2+7));


    }
}
