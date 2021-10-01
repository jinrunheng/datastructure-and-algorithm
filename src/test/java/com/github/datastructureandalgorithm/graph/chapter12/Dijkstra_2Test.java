package com.github.datastructureandalgorithm.graph.chapter12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Dijkstra_2Test {
    @Test
    void testDijkstra() {
        WeightedGraph G = new WeightedGraph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter12/g.txt");
        Dijkstra_2 dijkstra = new Dijkstra_2(G, 0);
        for (int v = 0; v < G.V(); v++)
            System.out.print(dijkstra.dis(v) + " ");
        System.out.println();
    }
}