package com.github.datastructureandalgorithm.graph.chapter9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamiltonPathTest {

    @Test
    void result() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter9/g3.txt");
        HamiltonPath hamiltonPath = new HamiltonPath(g, 0);
        // 从 0 出发有哈密尔顿路径
        System.out.println(hamiltonPath.result());


        hamiltonPath = new HamiltonPath(g, 1);
        // 从 1 出发没有哈密尔顿路径
        System.out.println(hamiltonPath.result());
    }
}