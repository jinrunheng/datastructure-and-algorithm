package com.github.datastructureandalgorithm.datastructure.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void getSize() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Assertions.assertEquals(linkedList.getSize(), 0);
        linkedList.addLast(1);
        Assertions.assertEquals(linkedList.getSize(), 1);
    }

    @Test
    void isEmpty() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Assertions.assertTrue(linkedList.isEmpty());
        linkedList.addLast(1);
        Assertions.assertFalse(linkedList.isEmpty());
    }

    @Test
    void add() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(i);
        }
        linkedList.add(100, 2);
        Assertions.assertEquals(linkedList.get(2), 100);
        Assertions.assertEquals(linkedList.getSize(), 11);
    }

    @Test
    void addFirst() {
    }

    @Test
    void addLast() {
    }

    @Test
    void get() {
    }

    @Test
    void getFirst() {
    }

    @Test
    void getLast() {
    }

    @Test
    void set() {
    }

    @Test
    void contains() {
    }

    @Test
    void remove() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(i);
        }
        linkedList.remove(2);
        Assertions.assertEquals(linkedList.getSize(), 9);
        Assertions.assertEquals(linkedList.get(2), 3);
    }

    @Test
    void removeFirst() {

    }

    @Test
    void removeLast() {

    }

    @Test
    void removeElement() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(5);
        linkedList.addLast(4);
        // 3->4->5->5->4->NULL

        linkedList.removeElement(4);
        // 3->5->5->4->NULL
        Assertions.assertEquals(linkedList.getSize(),4);
        Assertions.assertEquals(linkedList.get(0),3);
        Assertions.assertEquals(linkedList.get(1),5);
        Assertions.assertEquals(linkedList.get(2),5);
        Assertions.assertEquals(linkedList.get(3),4);
    }

    @Test
    void testToString() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(i);
        }
        // 0->1->2->3->4->5->6->7->8->9->NULL
        System.out.println(linkedList.toString());
    }
}