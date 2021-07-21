package com.github.datastructureandalgorithm.datastructure.SkipList;

import com.github.datastructureandalgorithm.datastructure.BST.BST;
import com.github.datastructureandalgorithm.datastructure.LinkedList.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class SkipListTest {

    @Test
    void contains() {
        SkipList<Integer> skipList = new SkipList<>();
        for (int i = 0; i < 10000; i++) {
            skipList.add(i);
        }
        Random random = new Random();
        Assertions.assertTrue(skipList.contains(random.nextInt(10000)));
        Assertions.assertFalse(skipList.contains(10000));
    }

    @Test
    void add() {
    }

    @Test
    void remove() {
        SkipList<Integer> skipList = new SkipList<>();
        for (int i = 0; i < 10000; i++) {
            skipList.add(i);
        }
        skipList.remove(100);
        Assertions.assertFalse(skipList.contains(100));
        Assertions.assertEquals(skipList.getSize(), 9999);
    }

    @Test
    void isEmpty() {
    }

    @Test
    void getSize() {
    }

    @Test
    void printAllElement() {
        SkipList<Integer> skipList = new SkipList<>();
        Assertions.assertTrue(skipList.isEmpty());
        skipList.add(1);
        skipList.add(2);
        skipList.add(3);
        skipList.printAllElement();
        Assertions.assertEquals(skipList.getSize(), 3);
        skipList.remove(2);
        skipList.printAllElement();
        Assertions.assertEquals(skipList.getSize(), 2);
        skipList.add(5);
        skipList.printAllElement();
    }

    @Test
    void SkipListPerformanceTest() {
        SkipList<Integer> skipList = new SkipList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 10000; i++) {
            skipList.add(i);
            linkedList.addLast(i);
            bst.add(i);
        }
        double time1 = testSkipList(skipList);
        double time2 = testBST(bst);
        System.out.println("SkipList contains : " + time1 + " s");
        System.out.println("BST contains : " + time2 + " s");
    }

    private static double testSkipList(SkipList<Integer> skipList) {
        Random random = new Random(10000);
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            skipList.contains(random.nextInt());
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    private static double testLinkedList(LinkedList<Integer> linkedList) {
        Random random = new Random(10000);
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.contains(random.nextInt());
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    private static double testBST(BST<Integer> bst) {
        Random random = new Random(10000);
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            bst.contains(random.nextInt());
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

}