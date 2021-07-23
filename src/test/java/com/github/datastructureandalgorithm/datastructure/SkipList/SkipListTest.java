package com.github.datastructureandalgorithm.datastructure.SkipList;

import com.github.datastructureandalgorithm.datastructure.BST.BST;
import com.github.datastructureandalgorithm.datastructure.LinkedList.LinkedList;
import com.github.datastructureandalgorithm.datastructure.dynamic_array.Array;
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
        for (int i = 0; i < 10; i++) {
            skipList.add(i);
        }
        skipList.remove(1);
        skipList.printAllElement();
    }


    @Test
    void SkipListPerformanceTest() {
        SkipList<Integer> skipList = new SkipList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 100000; i++) {
            skipList.add(i);
            linkedList.addLast(i);
        }
        Array<Integer> array = generateRandomArray();
        double time1 = testSkipList(skipList,array);
        System.out.println("SkipList contains : " + time1 + " s");
        // double time2 = testBST(bst,array);
        double time3 = testLinkedList(linkedList,array);
        System.out.println("LinkedList contains : " + time3 + " s");
        // System.out.println("BST contains : " + time2 + " s");
    }

    private static Array<Integer> generateRandomArray() {
        Array<Integer> array = new Array<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            array.addLast(random.nextInt(100000));
        }
        return array;
    }

    private static double testSkipList(SkipList<Integer> skipList, Array<Integer> array) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            skipList.contains(array.get(i));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    private static double testLinkedList(LinkedList<Integer> linkedList, Array<Integer> array) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.contains(array.get(i));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    private static double testBST(BST<Integer> bst, Array<Integer> array) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            bst.contains(array.get(i));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

}