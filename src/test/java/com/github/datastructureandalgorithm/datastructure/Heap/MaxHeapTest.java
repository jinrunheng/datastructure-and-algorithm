package com.github.datastructureandalgorithm.datastructure.Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class MaxHeapTest {

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
    void extractMax() {
    }

    @Test
    void findMax() {
    }

    @Test
    void testHeapifyAndHeapInsertPerformance() {
        int n = 1000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, true);
        System.out.println("Heapify : " + time1 + " s");

        double time2 = testHeap(testData, false);
        System.out.println("HeapInsert : " + time2 + " s");
    }

    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (int num : testData) {
                maxHeap.add(num);
            }
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < testData.length; i++) {
            Assertions.assertTrue(arr[i - 1] >= arr[i]);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }


    @Test
    void testAddAndExtractMax() {
        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            Assertions.assertTrue(arr[i - 1] >= arr[i]);
        }
    }
}