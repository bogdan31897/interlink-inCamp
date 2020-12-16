//package com.company;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TestLinkedList {
//
//    @Test
//    public void Test_IsEmpty() {
//        LinkedList list = new LinkedList();
//        list.append("first");
//        list.append("second");
//        assertFalse(list.isEmpty());
//    }
//
//    @Test
//    public void Test_append() {
//        LinkedList list = new LinkedList();
//
//        list.append("first");
//        list.insert("second");
//
//        StringBuilder result = new StringBuilder();
//
//        list.forEach(item -> result.append(item + " "));
//        assertEquals("second first ", result.toString());
//
//    }
//
//    @Test
//    public void Test_insert() {
//        LinkedList list = new LinkedList();
//
//        list.append("first");
//        list.insert("third");
//        list.append("second");
//        list.insert("fourth");
//
//        StringBuilder result = new StringBuilder();
//
//        list.forEach(item -> result.append(item + " "));
//        assertEquals("fourth third first second ", result.toString());
//
//    }
//    @Test
//    public void Test_toString() {
//
//        LinkedList list = new LinkedList();
//        list.insert("1");
//        list.insert("2");
//        list.insert("3");
//        list.insert("4");
//
//
//        StringBuilder result = new StringBuilder();
//
//        list.forEach(item -> result.append(item + " "));
//        assertEquals(list.toString(), result.toString());
//
//    }
//    @Test
//    public void Test_foreach() {
//        LinkedList list = new LinkedList();
//        list.append("first");
//        list.append("second");
//
//        StringBuilder result = new StringBuilder();
//
//        list.forEach(item -> result.append(item + " "));
//        assertEquals("first second ", result.toString());
//    }
//    @Test
//    public void Test_getItem() {
//        LinkedList list = new LinkedList();
//        list.append("first");
//
//
//        assertEquals("first", list.getItem(0));
//    }
//}