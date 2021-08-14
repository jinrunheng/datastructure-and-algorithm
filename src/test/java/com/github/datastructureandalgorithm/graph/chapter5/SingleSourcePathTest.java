package com.github.datastructureandalgorithm.graph.chapter5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleSourcePathTest {

    @Test
    void isConnectedTo() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g.txt");
        SingleSourcePath singleSourcePath = new SingleSourcePath(g,0);
        Assertions.assertTrue(singleSourcePath.isConnectedTo(6));
    }

    @Test
    void path() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g.txt");
        com.github.datastructureandalgorithm.graph.chapter4.Graph g2 = new com.github.datastructureandalgorithm.graph.chapter4.Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g.txt");
        SingleSourcePath singleSourcePath = new SingleSourcePath(g,0);
        com.github.datastructureandalgorithm.graph.chapter4.SingleSourcePath singleSourcePath2 = new com.github.datastructureandalgorithm.graph.chapter4.SingleSourcePath(g2,0);
        Iterable<Integer> path = singleSourcePath.path(6);
        Iterable<Integer> path2 = singleSourcePath2.path(6);
        System.out.println("BFS path 0 -> 6 : " + path);
        System.out.println("DFS path 0 -> 6 : " + path2);
    }

    @Test
    void path2(){
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g.txt");
        SingleSourcePath singleSourcePath = new SingleSourcePath(g,6);
        Iterable<Integer> path = singleSourcePath.path(5);
        System.out.println("BFS path 6 -> 5 : " + path);
    }
}