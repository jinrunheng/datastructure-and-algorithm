package com.github.datastructureandalgorithm.graph.chapter5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnweightedSingleSourceShortestPathTest {

    @Test
    void dis() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g.txt");
        UnweightedSingleSourceShortestPath path = new UnweightedSingleSourceShortestPath(g, 0);
        Assertions.assertEquals(path.dis(5), 3);
        Assertions.assertEquals(path.dis(6), 2);
    }
}