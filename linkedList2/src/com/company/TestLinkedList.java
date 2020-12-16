package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestLinkedList{


    @Test
    public void Test_insert() {
        LinkedList<Integer> list = new LinkedList<>();

        list.insert(2);
        list.insert(4);

        StringBuilder result = new StringBuilder();

        list.forEach(item -> result.append(item + " "));
        assertEquals("4 2 ", result.toString());

    }

    @Test    
    public void Test_insertAfter () {
        LinkedList<Integer> list = new LinkedList<>();

        list.insert(3);
        list.insert(4);
        list.insertAfter(0, 5);

        StringBuilder result = new StringBuilder();

        list.forEach(item -> result.append(item + " "));
        assertEquals("4 5 3 ", result.toString());
    }

    @Test
    public void Test_append () {
        LinkedList<Integer>list = new LinkedList<>();

        list.append(3);
        list.append(4);
        list.insert(1);

        StringBuilder result = new StringBuilder();

        list.forEach(item -> result.append(item + " "));
        assertEquals("1 3 4 ", result.toString());
    }

    @Test
    public void Test_removeAt () {
        LinkedList<Integer> list = new LinkedList<>();

        list.append(3);
        list.append(4);
        list.insert(1);
        list.removeAt(0);
        StringBuilder result = new StringBuilder();

        list.forEach(item -> result.append(item + " "));
        assertEquals("3 4 ", result.toString());
    }

    @Test
    public void Test_replaceAt () {
        LinkedList<Integer>list = new LinkedList<>();

        list.append(3);
        list.append(4);
        list.insert(1);
        list.removeAt(0);
        list.replaceAt(0, 10);
        StringBuilder result = new StringBuilder();

        list.forEach(item -> result.append(item + " "));
        assertEquals("10 4 ", result.toString());
    }

    @Test
    public void Test_getItem () {
        LinkedList<Integer>list = new LinkedList<>();

        list.append(3);
        list.append(4);
        list.insert(1);

        assertEquals(1, list.getItem(0));
    }

    @Test
    public void Test_IsEmpty() {
        LinkedList<Integer>list = new LinkedList<>();
        list.append(1);
        assertFalse(list.isEmpty());
    }



    @Test
    public void Test_toString() {

        LinkedList<Integer>list = new LinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);


        StringBuilder result = new StringBuilder();

        list.forEach(item -> result.append(item + " "));
        assertEquals(list.toString(), result.toString());

    }
}