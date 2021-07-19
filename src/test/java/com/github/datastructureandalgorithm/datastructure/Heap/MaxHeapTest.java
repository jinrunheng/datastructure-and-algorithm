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