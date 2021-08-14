package com.github.datastructureandalgorithm.graph.chapter5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BipartitionDetectionTest {

    @Test
    void isBipartite() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g.txt");
        BipartitionDetection bipartitionDetection = new BipartitionDetection(g);
        Assertions.assertTrue(bipartitionDetection.isBipartite());
    }
}