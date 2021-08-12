package com.github.datastructureandalgorithm.algorithm.sort;

import com.github.datastructureandalgorithm.algorithm.util.SwapUtils;

public class SelectionSort {

    private SelectionSort() {

    }

    public static<T extends Comparable> void sort(T[] arr) {
        if (arr == null || arr.length < 2)
            return;

        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
                minIndex = arr[minIndex].compareTo(arr[j]) > 0 ? j : minIndex;

            SwapUtils.swap(arr, minIndex, i);
        }
    }
}
