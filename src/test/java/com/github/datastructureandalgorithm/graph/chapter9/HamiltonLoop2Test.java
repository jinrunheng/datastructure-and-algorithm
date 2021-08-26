package com.github.datastructureandalgorithm.graph.chapter9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamiltonLoop2Test {

    @Test
    void result() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter9/g.txt");
        HamiltonLoop2 hamiltonLoop = new HamiltonLoop2(g);
        System.out.println(hamiltonLoop.result());
    }


    @Test
    /**
     * 哈密尔顿问题
     */
    void result2() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter9/g2.txt");
        HamiltonLoop2 hamiltonLoop = new HamiltonLoop2(g);
        System.out.println(hamiltonLoop.result());
    }
}