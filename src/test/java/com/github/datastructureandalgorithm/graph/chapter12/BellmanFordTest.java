package com.github.datastructureandalgorithm.graph.chapter12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BellmanFordTest {

    @Test
    void testBellmanFord() {
        WeightedGraph G = new WeightedGraph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter12/g.txt");
        BellmanFord bellmanFord = new BellmanFord(G, 0);
        if (!bellmanFord.hasNegativeCycle) {
            for (int v = 0; v < G.V(); v++)
                System.out.print(bellmanFord.dis(v) + " ");
            System.out.println();
        } else
            System.out.println("Exist negative cycle");
    }
}