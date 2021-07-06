package com.github.datastructureandalgorithm.datastructure.dynamic_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @Test
    void getSize() {
        Array array = new Array();
        assertEquals(array.getSize(),0);
        array.addLast(1);
        assertEquals(array.getSize(),1);
    }

    @Test
    void getCapacity() {
        Array array1 = new Array();
        Array array2 = new Array(20);
        assertEquals(array1.getCapacity(),10);
        assertEquals(array2.getCapacity(),20);
    }

    @Test
    void isEmpty() {
        Array array = new Array();
        assertTrue(array.isEmpty());
        array.addLast(1);
        assertFalse(array.isEmpty());
    }


    @Test
    void addFirstAndLast() {
        Array array = new Array(20);
        for(int i = 0; i < 10; i++){
            array.addLast(1);
        }
        array.addFirst(-1);
        assertEquals(11, array.getSize());
    }

    @Test
    void add() {
    }

    @Test
    void testToString() {
        Array array = new Array(20);
        for(int i = 0; i < 10; i++){
            array.addLast(i);
        }
        // Array: size = 10, capacity = 20
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(array);
    }
}