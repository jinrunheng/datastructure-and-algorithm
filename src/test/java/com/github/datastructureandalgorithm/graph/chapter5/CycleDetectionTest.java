package com.github.datastructureandalgorithm.graph.chapter5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CycleDetectionTest {

    @Test
    void hasCycle() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g3.txt");
        CycleDetection cycleDetection = new CycleDetection(g);
        Assertions.assertTrue(cycleDetection.hasCycle());
        Graph g2 = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g4.txt");
        cycleDetection = new CycleDetection(g2);
        Assertions.assertFalse(cycleDetection.hasCycle());
    }
}