package com.github.datastructureandalgorithm.graph.chapter8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindBridgesTest {

    @Test
    void result() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter8/g.txt");
        FindBridges fb = new FindBridges(g);
        System.out.println(fb.result());
    }

    @Test
    void result2(){
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter8/g2.txt");
        FindBridges fb = new FindBridges(g);
        System.out.println(fb.result());
    }
}