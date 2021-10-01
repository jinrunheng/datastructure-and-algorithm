package com.github.datastructureandalgorithm.graph.chapter12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BellmanFord_2Test {
    @Test
    void testBellmanFord() {
        WeightedGraph G = new WeightedGraph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter12/g.txt");
        BellmanFord_2 bellmanFord = new BellmanFord_2(G, 0);
        if (!bellmanFord.hasNegativeCycle) {
            for (int v = 0; v < G.V(); v++)
                System.out.print(bellmanFord.dis(v) + " ");
            System.out.println();
            System.out.println(bellmanFord.path(3));
        } else
            System.out.println("Exist negative cycle");
    }
}