package com.github.datastructureandalgorithm.graph.chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathTest {

    @Test
    void path(){
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter4/g.txt");
        Path p = new Path(g,0,4);
        System.out.println(p.path());
    }
}