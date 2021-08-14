package com.github.datastructureandalgorithm.graph.chapter5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnweightedShortestPathTest {

    @Test
    void dis() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g.txt");
        UnweightedShortestPath path = new UnweightedShortestPath(g,0,6);
        Assertions.assertEquals(path.dis(),2);
    }
}