package com.github.datastructureandalgorithm.datastructure.AVL;

import com.github.datastructureandalgorithm.datastructure.BST.BST;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    @Test
    void AVLAndBSTPerformanceTest() {
        int[] testArr = new int[20000];
        for (int i = 0; i < testArr.length; i++)
            testArr[i] = i;
        testBst(testArr);
        testAvl(testArr);
    }

    @Test
    void AVLTest(){
        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < 1000; i++){
            avl.add(i);
            if(!avl.isBalanced() || !avl.isBST())
                throw new RuntimeException("error!");
        }
        for(int i = 0; i < 1000; i++){
            avl.remove(i);
            if(!avl.isBalanced() || !avl.isBST())
                throw new RuntimeException("error!");
        }
        System.out.println("correct!");

    }

    private void testBst(int[] testArr) {
        BST<Integer> bst = new BST<>();
        long start = System.nanoTime();
        for (int i = 0; i < testArr.length; i++)
            bst.add(i);
        for (int i = 0; i < testArr.length; i++)
            if (!bst.contains(i)) throw new RuntimeException("error");
        long end = System.nanoTime();
        System.out.println("BST : " + (end - start) / 1000000000.0 + " s");
    }

    private void testAvl(int[] testArr) {
        AVLTree<Integer> avl = new AVLTree<>();
        long start = System.nanoTime();
        for (int i = 0; i < testArr.length; i++)
            avl.add(i);
        for (int i = 0; i < testArr.length; i++)
            if (!avl.contains(i)) throw new RuntimeException("error");
        long end = System.nanoTime();
        System.out.println("AVL : " + (end - start) / 1000000000.0 + " s");
    }
}