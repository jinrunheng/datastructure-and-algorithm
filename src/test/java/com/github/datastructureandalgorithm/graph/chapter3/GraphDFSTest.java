package com.github.datastructureandalgorithm.graph.chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphDFSTest {

    @Test
    void testGraphDFS(){
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter3/g.txt");
        GraphDFS dfs = new GraphDFS(g);
        System.out.println(dfs.order());
    }
}