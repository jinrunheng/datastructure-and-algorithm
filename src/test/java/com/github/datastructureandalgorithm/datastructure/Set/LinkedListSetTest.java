package com.github.datastructureandalgorithm.datastructure.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListSetTest {

    @Test
    void add() {
        Set<String> set = new LinkedListSet<>();
        set.add("hello");
        set.add("world");
        Assertions.assertEquals(set.getSize(), 2);
    }

    @Test
    void remove() {
        Set<String> set = new LinkedListSet<>();
        set.add("hello");
        set.add("world");
        set.remove("hello");
        set.remove("Java");
        Assertions.assertEquals(set.getSize(), 1);
        set.remove("world");
        Assertions.assertTrue(set.isEmpty());
    }

    @Test
    void contains() {
    }

    @Test
    void getSize() {
    }

    @Test
    void isEmpty() {
    }
}