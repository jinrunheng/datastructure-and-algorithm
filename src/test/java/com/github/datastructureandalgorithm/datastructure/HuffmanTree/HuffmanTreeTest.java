package com.github.datastructureandalgorithm.datastructure.HuffmanTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class HuffmanTreeTest {

    @Test
    void createHuffmanTree() {
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
        // HuffmanTree
        //        15(null)
        //    /            \
        //   6(null)        9(null)
        //  / \            / \
        // 3   3(null)    4   5
        //    / \
        //   1   2

        // WPL = 5 * 2 + 4 * 2 + 3 * 2 + 2 * 3 + 1 * 3 = 33
        Assertions.assertEquals(HuffmanTree.getWPL(root), 33);
    }
}