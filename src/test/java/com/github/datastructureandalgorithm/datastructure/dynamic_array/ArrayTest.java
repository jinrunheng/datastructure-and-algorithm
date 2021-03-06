package com.github.datastructureandalgorithm.datastructure.dynamic_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @Test
    void getSize() {
        Array<Integer> array = new Array();
        assertEquals(array.getSize(), 0);
        array.addLast(1);
        assertEquals(array.getSize(), 1);
    }

    @Test
    void getCapacity() {
        Array<Integer> array1 = new Array();
        Array<Integer> array2 = new Array(20);
        assertEquals(array1.getCapacity(), 10);
        assertEquals(array2.getCapacity(), 20);
    }

    @Test
    void isEmpty() {
        Array<Integer> array = new Array();
        assertTrue(array.isEmpty());
        array.addLast(1);
        assertFalse(array.isEmpty());
    }


    @Test
    void addFirstAndLast() {
        Array<Integer> array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(1);
        }
        array.addFirst(-1);
        assertEquals(11, array.getSize());
    }

    @Test
    void add() {
        Array<Integer> array = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        array.add(100, 5);
        assertEquals(array.get(5), 100);
        assertEquals(array.getSize(), 11);
    }

    @Test
    void testToString() {
        Array<Integer> array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        // Array: size = 10, capacity = 20
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(array);
    }

    @Test
    void testRemoveAllElements() {
        Array<Integer> array = new Array();
        array.addLast(3);
        array.addLast(2);
        array.addLast(4);
        array.addLast(2);
        array.addLast(5);
        array.removeAllElements(2);
        assertEquals(array.getSize(), 3);
        assertFalse(array.contains(2));
    }

    @Test
    void testRemoveElement() {
        Array<Integer> array = new Array();
        array.addLast(3);
        array.addLast(2);
        array.addLast(4);
        array.addLast(2);
        array.addLast(5);
        array.removeElement(2);
        assertEquals(array.getSize(), 4);
        assertTrue(array.contains(2));
    }

    @Test
    void testFindAll() {
        Array<Integer> array = new Array();
        array.addLast(3);
        array.addLast(2);
        array.addLast(4);
        array.addLast(2);
        array.addLast(5);
        int[] find = array.findAll(2);
        assertEquals(find.length, 2);
        assertEquals(find[0], 1);
        assertEquals(find[1], 3);
        assertEquals(0, array.findAll(6).length);
    }

    @Test
    void testResize() {
        Array<Integer> array = new Array<>(); // init capacity = 10
        for (int i = 0; i < 10; i++) {
            array.addLast(1);
        }
        array.addLast(1);//  -----> resize capacity = 20
        assertEquals(array.getCapacity(), 20); // size = 11 capacity = 20
        for (int i = 0; i < 6; i++) {
            array.removeLast();
        }
        assertEquals(array.getCapacity(), 10);
    }
}