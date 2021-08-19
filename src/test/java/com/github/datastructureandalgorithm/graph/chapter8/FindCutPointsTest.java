package com.github.datastructureandalgorithm.graph.chapter8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindCutPointsTest {

    @Test
    void result() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter8/g.txt");
        FindCutPoints fcp = new FindCutPoints(g);
        System.out.println(fcp.result());
    }
}