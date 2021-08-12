package com.github.datastructureandalgorithm.algorithm.util;

import java.util.Random;

public class ArrayGenerator {
    private ArrayGenerator() {

    }

    /**
     * 生成一个长度为 n，类型为 Integer 的顺序数组 [0...n-1]
     *
     * @param n
     * @return
     */
    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;
        return arr;
    }

    /**
     * 生成一个长度为 n ，类型为 Integer 的随机数组，每个数字的范围为 [0,bound)
     *
     * @param n
     * @param bound
     * @return
     */
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random r = new Random();
        for (int i = 0; i < n; i++)
            arr[i] = r.nextInt(bound);
        return arr;
    }
}
