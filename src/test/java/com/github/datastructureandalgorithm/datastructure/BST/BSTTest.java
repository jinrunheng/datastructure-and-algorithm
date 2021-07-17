package com.github.datastructureandalgorithm.datastructure.BST;

import com.github.datastructureandalgorithm.algorithm.util.TreeUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void add() {
    }

    @Test
    void contains() {
    }

    @Test
    void proOrder() {
        //    11
        //   /  \
        //  7    14
        // / \   / \
        //5  9  12  16
        BST<Integer> bst = new BST<>();
        bst.add(11);
        bst.add(7);
        bst.add(14);
        bst.add(5);
        bst.add(9);
        bst.add(12);
        bst.add(16);
        bst.proOrder();
        System.out.println();
        TreeUtils.preOrder(bst.getRoot());
    }
}