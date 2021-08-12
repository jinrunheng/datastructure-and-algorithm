package com.github.datastructureandalgorithm.algorithm.sort;

import com.github.datastructureandalgorithm.algorithm.util.SwapUtils;

public class InsertionSort {
    private InsertionSort() {

    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length < 2)
            return;

        for (int i = 1; i < arr.length; i++)
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--)
                SwapUtils.swap(arr, j, j - 1);
    }
}
