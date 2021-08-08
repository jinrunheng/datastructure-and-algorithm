package com.github.datastructureandalgorithm.graph.chapter3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphDFSnrTest {

    @Test
    void testGraphDFSnr() {

        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter3/g2.txt");
        GraphDFSnr dfSnr = new GraphDFSnr(g);
        System.out.println(dfSnr.pre());

    }
}