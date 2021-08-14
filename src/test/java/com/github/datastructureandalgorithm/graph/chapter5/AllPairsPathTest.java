package com.github.datastructureandalgorithm.graph.chapter5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllPairsPathTest {

    @Test
    void isConnectedTo() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g.txt");
        AllPairsPath path = new AllPairsPath(g);
        Assertions.assertTrue(path.isConnectedTo(0, 6));
    }

    @Test
    void path() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g.txt");
        AllPairsPath allPairsPath = new AllPairsPath(g);
        Iterable<Integer> path = allPairsPath.path(0, 6);
        System.out.println("path 0->6 : " + path);
    }
}