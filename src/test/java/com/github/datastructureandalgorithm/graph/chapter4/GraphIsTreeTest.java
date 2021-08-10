package com.github.datastructureandalgorithm.graph.chapter4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphIsTreeTest {

    @Test
    void isTree() {
        Graph g1 = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter4/g3.txt");
        GraphIsTree graphIsTree = new GraphIsTree(g1);
        Assertions.assertTrue(graphIsTree.isTree());

        Graph g2 = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter4/g2.txt");
        graphIsTree = new GraphIsTree(g2);
        Assertions.assertFalse(graphIsTree.isTree());
    }
}