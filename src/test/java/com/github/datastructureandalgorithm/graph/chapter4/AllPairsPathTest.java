package com.github.datastructureandalgorithm.graph.chapter4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllPairsPathTest {

    @Test
    void testAllPairsPath() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter4/g.txt");
        AllPairsPath allPairsPath = new AllPairsPath(g);
        Assertions.assertTrue(allPairsPath.isConnectedTo(0, 6));
        Iterable<Integer> path = allPairsPath.path(0, 4);
        System.out.println(path);
    }

}