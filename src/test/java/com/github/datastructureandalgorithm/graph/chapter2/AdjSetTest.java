package com.github.datastructureandalgorithm.graph.chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdjSetTest {

    @Test
    void testAdjSet(){
        AdjSet adjSet = new AdjSet("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter2/g.txt");
        System.out.println(adjSet);
    }
}