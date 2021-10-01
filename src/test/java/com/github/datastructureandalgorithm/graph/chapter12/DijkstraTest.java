package com.github.datastructureandalgorithm.graph.chapter12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void testDijkstra() {
        WeightedGraph G = new WeightedGraph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter12/g.txt");
        Dijkstra dijkstra = new Dijkstra(G, 0);
        for (int v = 0; v < G.V(); v++)
            System.out.print(dijkstra.dis(v) + " ");
        System.out.println();
    }
}