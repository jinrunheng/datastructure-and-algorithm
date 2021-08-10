package com.github.datastructureandalgorithm.graph.chapter5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphBFSTest {

    @Test
    void order() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g.txt");
        GraphBFS bfs = new GraphBFS(g);
        System.out.println(bfs.order());
    }
}