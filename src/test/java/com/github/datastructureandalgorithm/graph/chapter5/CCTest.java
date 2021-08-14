package com.github.datastructureandalgorithm.graph.chapter5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CCTest {

    @Test
    void isConnected() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g2.txt");
        CC cc = new CC(g);
        Assertions.assertTrue(cc.isConnected(0,6));
        Assertions.assertFalse(cc.isConnected(0,5));
    }

    @Test
    void components() {
        Graph g = new Graph("/Users/macbook/Desktop/myProject/datastructure-and-algorithm/src/main/resources/graph/chapter5/g2.txt");
        CC cc = new CC(g);
        List<Integer>[] components = cc.components();
        for(List<Integer> component : components){
            System.out.println(component);
        }
    }
}