package com.github.datastructureandalgorithm.graph.chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void testGraph(){
        Graph graph = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter2/g.txt");
        System.out.println(graph);
    }
}