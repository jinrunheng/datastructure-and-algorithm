package com.github.datastructureandalgorithm.graph.chapter4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CCTest {

    @Test
    void testCC() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter4/g.txt");
        CC cc = new CC(g);
        Assertions.assertEquals(cc.count(), 2);
    }
}