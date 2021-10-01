package com.github.datastructureandalgorithm.graph.chapter12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloyedTest {

    @Test
    void testFloyed(){
        WeightedGraph G = new WeightedGraph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter12/g.txt");
        Floyed floyed = new Floyed(G);
        if (!floyed.hasNegativeCycle) {
            for (int v = 0; v < G.V(); v++){
                for (int w = 0; w < G.V(); w++){
                    System.out.print(floyed.dis(v,w) + " ");
                }
                System.out.println();
            }
        }else
            System.out.println("Exist negative cycle");
    }
}