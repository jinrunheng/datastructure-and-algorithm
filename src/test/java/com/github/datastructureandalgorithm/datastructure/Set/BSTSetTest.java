package com.github.datastructureandalgorithm.datastructure.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BSTSetTest {

    @Test
    void add() {
        Set<String> set = new BSTSet<>();
        set.add("hello");
        set.add("world");
        Assertions.assertEquals(set.getSize(), 2);
        set.add("hello");
        Assertions.assertEquals(set.getSize(), 2);
    }

    @Test
    void remove() {
        Set<String> set = new BSTSet<>();
        set.add("hello");
        set.add("world");
        set.remove("hello");
        Assertions.assertEquals(set.getSize(), 1);

    }

    @Test
    void contains() {
        Set<String> set = new BSTSet<>();
        set.add("hello");
        set.add("world");
        Assertions.assertTrue(set.contains("hello"));
        Assertions.assertFalse(set.contains("Java"));
    }

    @Test
    void getSize() {
        Set<String> set = new BSTSet<>();
        set.add("hello");
        set.add("world");
        Assertions.assertEquals(set.getSize(), 2);
        set.add("hello");
        set.add("world");
        Assertions.assertEquals(set.getSize(), 2);
    }

    @Test
    void isEmpty() {
        Set<String> set = new BSTSet<>();
        Assertions.assertTrue(set.isEmpty());
        set.add("hello");
        Assertions.assertFalse(set.isEmpty());
    }
}