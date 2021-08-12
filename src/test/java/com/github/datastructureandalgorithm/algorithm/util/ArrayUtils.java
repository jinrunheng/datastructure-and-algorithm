package com.github.datastructureandalgorithm.algorithm.util;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {
    /**
     * @param array 拷贝的原数组
     * @return 拷贝的数组
     */
    public static Integer[] copyArray(Integer[] array) {
        int[] copy = new int[array.length];
        return Arrays.copyOfRange(array, 0, array.length);
    }

    /**
     * @param arrLen   生成的数组长度
     * @param maxRange 数组的范围 [0,maxRange)
     * @return 生成的数组
     */
    public static Integer[] generateRandomArray(int arrLen, int maxRange) {
        Integer[] ret = new Integer[arrLen];
        for (int i = 0; i < arrLen; i++) {
            ret[i] = new Random(maxRange).nextInt();
        }
        return ret;
    }
}
