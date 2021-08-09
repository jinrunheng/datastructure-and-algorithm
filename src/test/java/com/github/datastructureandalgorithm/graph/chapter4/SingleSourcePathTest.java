package com.github.datastructureandalgorithm.graph.chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleSourcePathTest {

    @Test
    void path() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter4/g.txt");
        SingleSourcePath singleSourcePath = new SingleSourcePath(g, 0);
        Iterable<Integer> path = singleSourcePath.path(4);
        System.out.println("0 -> 6 " + path);
    }
}