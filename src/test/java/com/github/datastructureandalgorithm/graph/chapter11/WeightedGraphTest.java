package com.github.datastructureandalgorithm.graph.chapter11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightedGraphTest {

    @Test
    void testWeightedGraph() {
        WeightedGraph g = new WeightedGraph("src/main/resources/graph/chapter11/g.txt");
        System.out.println(g);
    }
}