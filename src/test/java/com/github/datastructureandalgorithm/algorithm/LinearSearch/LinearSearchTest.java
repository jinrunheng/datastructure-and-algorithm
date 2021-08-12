package com.github.datastructureandalgorithm.algorithm.LinearSearch;

import com.github.datastructureandalgorithm.algorithm.util.ArrayGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

    @Test
    void search() {
        String[] strings = {"A", "B", "C", "D", "E"};
        int index = LinearSearch.search(strings, "B");
        Assertions.assertEquals(index, 1);
    }

    @Test
    void performanceTest() {
        int[] dataSize = {100_0000, 1000_0000};
        for (int size : dataSize) {
            Integer[] testData = ArrayGenerator.generateOrderedArray(size);
            long start = System.nanoTime();

            for (int i = 0; i < 10; i++)
                LinearSearch.search(testData, size);

            long end = System.nanoTime();
            System.out.println("t : " + (end - start) / 1000000000.0 + "s");
        }
    }
}