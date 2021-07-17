package com.github.datastructureandalgorithm.algorithm.util;

import com.github.datastructureandalgorithm.datastructure.BST.BST;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeUtilsTest {

    @Test
    void printTree() {
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
//           11
//         7   14
//        5 9 12 16
        TreeUtils.printTree(bst.getRoot());
    }

    @Test
    void getTreeDepth() {
        //    11
        //   /  \
        //  7    14
        // / \   / \
        //5  9  12  16
        BST<Integer> bst = new BST<>();
        Assertions.assertEquals(TreeUtils.getTreeDepth(bst.getRoot()), 0);
        bst.add(11);
        bst.add(7);
        bst.add(14);
        bst.add(5);
        bst.add(9);
        bst.add(12);
        bst.add(16);
        Assertions.assertEquals(TreeUtils.getTreeDepth(bst.getRoot()), 3);
    }
}