package com.github.datastructureandalgorithm.graph.chapter11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimTest {

    @Test
    void result() {
        WeightedGraph g = new WeightedGraph("src/main/resources/graph/chapter11/g.txt");
        Prim prim = new Prim(g);
        System.out.println(prim.result());
    }
}