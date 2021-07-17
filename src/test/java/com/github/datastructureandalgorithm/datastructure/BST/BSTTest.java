package com.github.datastructureandalgorithm.datastructure.BST;

import com.github.datastructureandalgorithm.algorithm.util.TreeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void size() {
        BST<Integer> bst = new BST<>();
        Assertions.assertEquals(bst.size(), 0);
        bst.add(1);
        Assertions.assertEquals(bst.size(), 1);
    }

    @Test
    void isEmpty() {
        BST<Integer> bst = new BST<>();
        Assertions.assertTrue(bst.isEmpty());
    }

    @Test
    void getRoot() {
        BST<Integer> bst = new BST<>();
        //    11
        //   /  \
        //  7    14
        // / \   / \
        //5  9  12  16
        bst.add(11);
        bst.add(7);
        bst.add(14);
        bst.add(5);
        bst.add(9);
        bst.add(12);
        bst.add(16);
        Assertions.assertEquals(bst.getRoot().e, 11);
    }

    @Test
    void contains() {
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
        Assertions.assertTrue(bst.contains(12));
        Assertions.assertFalse(bst.contains(15));
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