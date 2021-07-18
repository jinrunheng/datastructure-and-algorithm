package com.github.datastructureandalgorithm.datastructure.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BSTMapTest {

    @Test
    void add() {
        Map<String, String> map = new BSTMap<>();
        map.add("a", "1");
        map.add("b", "2");
        map.add("c", "3");
        Assertions.assertEquals(map.getSize(), 3);
    }

    @Test
    void remove() {
        Map<String, String> map = new BSTMap<>();
        map.add("a", "1");
        map.add("b", "2");
        map.add("c", "3");
        Assertions.assertEquals(map.getSize(), 3);
        map.remove("a");
        Assertions.assertEquals(map.getSize(), 2);
    }

    @Test
    void contains() {
    }

    @Test
    void get() {
    }

    @Test
    void set() {
        Map<String, String> map = new BSTMap<>();
        map.add("a", "1");
        map.add("b", "2");
        map.add("c", "3");
        map.set("b", "100");
        Assertions.assertEquals(map.get("b"), "100");
    }
}