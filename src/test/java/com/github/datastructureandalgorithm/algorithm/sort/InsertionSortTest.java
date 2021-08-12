package com.github.datastructureandalgorithm.algorithm.sort;

import com.github.datastructureandalgorithm.algorithm.util.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void sort() {
        Integer[] randomArray = ArrayUtils.generateRandomArray(100, 100);
        Integer[] copyArray = ArrayUtils.copyArray(randomArray);
        Arrays.sort(randomArray);
        InsertionSort.sort(copyArray);
        for(int i = 0; i < randomArray.length; i++)
            Assertions.assertEquals(randomArray[i],copyArray[i]);
    }
}