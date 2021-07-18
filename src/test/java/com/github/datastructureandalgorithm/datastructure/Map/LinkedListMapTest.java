package com.github.datastructureandalgorithm.datastructure.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListMapTest {

    @Test
    void add() {
        Map<String, String> map = new LinkedListMap<>();
        map.add("a", "1");
        map.add("b", "2");
        map.add("c", "3");
        Assertions.assertEquals(map.getSize(), 3);
    }

    @Test
    void remove() {
        Map<String, String> map = new LinkedListMap<>();
        map.add("a", "1");
        map.add("b", "2");
        map.add("c", "3");
        map.remove("d");
        map.remove("a");
        Assertions.assertEquals(map.getSize(), 2);
    }

    @Test
    void contains() {
        Map<String, String> map = new LinkedListMap<>();
        Assertions.assertFalse(map.contains("a"));
        map.add("a", "1");
        Assertions.assertTrue(map.contains("a"));
    }

    @Test
    void get() {
    }

    @Test
    void set() {
        Map<String, String> map = new LinkedListMap<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> map.set("a","1"));
        map.add("a","1");
        Assertions.assertEquals(map.get("a"),"1");
    }

    @Test
    void getSize() {
    }

    @Test
    void isEmpty() {
    }
}