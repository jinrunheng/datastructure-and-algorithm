package com.github.datastructureandalgorithm.graph.chapter11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KruskalTest {

    @Test
    void result() {
        WeightedGraph g = new WeightedGraph("src/main/resources/graph/chapter11/g.txt");
        Kruskal kruskal = new Kruskal(g);
        System.out.println(kruskal.result());
    }
}