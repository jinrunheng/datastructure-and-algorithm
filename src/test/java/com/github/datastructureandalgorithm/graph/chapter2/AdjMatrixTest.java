package com.github.datastructureandalgorithm.graph.chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdjMatrixTest {

    @Test
    void testAdjMatrix(){
        AdjMatrix adjMatrix = new AdjMatrix("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter2/g.txt");
        System.out.println(adjMatrix);
    }
}