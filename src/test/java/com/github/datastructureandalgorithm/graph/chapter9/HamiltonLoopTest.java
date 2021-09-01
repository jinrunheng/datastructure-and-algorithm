package com.github.datastructureandalgorithm.graph.chapter9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamiltonLoopTest {

    @Test
    void result() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter9/g.txt");
        HamiltonLoop hamiltonLoop = new HamiltonLoop(g);
        System.out.println(hamiltonLoop.result());
    }


    @Test
    /**
     * 哈密尔顿问题
     */
    void result2() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter9/g2.txt");
        HamiltonLoop hamiltonLoop = new HamiltonLoop(g);
        System.out.println(hamiltonLoop.result());
    }

    @Test
    void result4(){
        String path = "/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter9/g4.txt";
        System.out.println(new HamiltonLoop(new Graph(path)).result());
    }

    @Test
    void result5(){
        String path = "/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter9/g5.txt";
        System.out.println(new HamiltonLoop(new Graph(path)).result());
    }
}