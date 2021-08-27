package com.github.datastructureandalgorithm.graph.chapter9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamiltonLoop_SRTest {

    @Test
    void result1() {
        String path = "/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter9/g.txt";
        System.out.println(new HamiltonLoop_SR(new Graph(path)).result());
    }

    @Test
    void result2() {
        String path = "/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter9/g2.txt";
        System.out.println(new HamiltonLoop_SR(new Graph(path)).result());
    }

}