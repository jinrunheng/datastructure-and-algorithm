package com.github.datastructureandalgorithm.graph.chapter4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CCTest {

    @Test
    void testCC() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter4/g.txt");
        CC cc = new CC(g);
        Assertions.assertEquals(cc.count(), 2);
    }

    @Test
    void isConnected() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter4/g.txt");
        CC cc = new CC(g);
        Assertions.assertTrue(cc.isConnected(0, 6));
        Assertions.assertFalse(cc.isConnected(0, 5));
    }

    @Test
    void testComponents() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter4/g.txt");
        CC cc = new CC(g);
        List<Integer>[] components = cc.components();
        for (List<Integer> list : components) {
            System.out.println(list);
        }
    }
}