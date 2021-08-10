package com.github.datastructureandalgorithm.graph.chapter4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CycleDetectionTest {

    @Test
    void hasCycle() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter4/g.txt");
        CycleDetection cycleDetection = new CycleDetection(g);
        Assertions.assertTrue(cycleDetection.hasCycle());
        Graph g2 = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter4/g2.txt");
        cycleDetection = new CycleDetection(g2);
        Assertions.assertFalse(cycleDetection.hasCycle());

    }
}