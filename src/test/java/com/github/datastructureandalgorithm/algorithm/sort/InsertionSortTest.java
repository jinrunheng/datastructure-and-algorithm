package com.github.datastructureandalgorithm.algorithm.sort;

import com.github.datastructureandalgorithm.algorithm.util.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void sort() {
        int[] testArr = ArrayUtils.generateRandomArray(100, 100);
        int[] testArr2 = ArrayUtils.copyArray(testArr);

        Arrays.sort(testArr);
        InsertionSort.sort(testArr2);
        for (int i = 0; i < testArr.length; i++) {
            Assertions.assertEquals(testArr[i], testArr2[i]);
        }
    }
}