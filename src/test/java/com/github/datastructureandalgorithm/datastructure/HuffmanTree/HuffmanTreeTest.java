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

        nodes.add(new Node("d", 30));
        nodes.add(new Node("d", 10));
        nodes.add(new Node("a", 5));
        nodes.add(new Node("b", 15));
        nodes.add(new Node("c", 40));
        Node root = HuffmanTree.createHuffmanTree(nodes);
        // 205
        System.out.println(HuffmanTree.getWPL(root));
    }
}