package com.github.datastructureandalgorithm.algorithm.sort;

import com.github.datastructureandalgorithm.algorithm.util.SwapUtils;

public class SelectionSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            SwapUtils.swap(arr, minIndex, i);
        }
    }
}
