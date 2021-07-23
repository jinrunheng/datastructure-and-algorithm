package com.github.datastructureandalgorithm.datastructure.HuffmanTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HuffmanTreeTest {

    @Test
    void createHuffmanTree() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node("e", 10));
        nodes.add(new Node("d", 30));
        nodes.add(new Node("a", 5));
        nodes.add(new Node("b", 15));
        nodes.add(new Node("c", 40));

        Node root = HuffmanTree.createHuffmanTree(nodes);
        System.out.println(HuffmanTree.levelOrder(root));

    }

    @Test
    void levelOrder() {
    }

    @Test
    void getWPL() {
        List<Node> nodes = new ArrayList<>();

        nodes.add(new Node("A", 0));
        nodes.add(new Node("B", 1));
        nodes.add(new Node("C", 2));
        nodes.add(new Node("D", 3));
        nodes.add(new Node("E", 4));
        nodes.add(new Node("F", 5));
        nodes.add(new Node("G", 6));
        nodes.add(new Node("H", 7));
        nodes.add(new Node("I", 8));

        Node root = HuffmanTree.createHuffmanTree(nodes);
        // 103
        System.out.println(HuffmanTree.getWPL(root));
    }
}