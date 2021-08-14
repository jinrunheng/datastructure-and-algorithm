package com.github.datastructureandalgorithm.graph.chapter5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleSourcePathTest {

    @Test
    void isConnectedTo() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g.txt");
        SingleSourcePath singleSourcePath = new SingleSourcePath(g,0);
        Assertions.assertTrue(singleSourcePath.isConnectedTo(6));
    }

    @Test
    void path() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g.txt");
        SingleSourcePath singleSourcePath = new SingleSourcePath(g,0);
        Iterable<Integer> path = singleSourcePath.path(6);
        System.out.println("path 0 -> 6 : " + path);
    }
}