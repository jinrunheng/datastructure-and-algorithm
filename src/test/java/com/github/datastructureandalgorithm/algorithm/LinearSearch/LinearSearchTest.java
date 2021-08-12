package com.github.datastructureandalgorithm.algorithm.LinearSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

    @Test
    void search() {
        String[] strings = {"A", "B", "C", "D", "E"};
        int index = LinearSearch.search(strings, "B");
        Assertions.assertEquals(index,1);
    }

    @Test
    void performanceTest(){
        int[] dataSize = {100_0000,1000_0000};
        for(int size : dataSize){

        }
    }
}