package com.github.datastructureandalgorithm.graph.chapter5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathTest {

    @Test
    void isConnected() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g2.txt");
        Path path = new Path(g, 0, 6);
        Assertions.assertTrue(path.isConnected());
        path = new Path(g, 0, 5);
        Assertions.assertFalse(path.isConnected());
    }

    @Test
    void path() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g2.txt");
        Path path = new Path(g, 0, 6);
        Iterable<Integer> p = path.path();
        System.out.println("path 0->6 : " + p);

    }
}