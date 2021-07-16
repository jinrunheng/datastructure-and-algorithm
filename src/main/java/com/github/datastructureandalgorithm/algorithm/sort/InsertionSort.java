package com.github.datastructureandalgorithm.algorithm.sort;

import com.github.datastructureandalgorithm.algorithm.util.MyUtils;

public class InsertionSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                MyUtils.swap(arr, j, j - 1);
            }
        }
    }
}
