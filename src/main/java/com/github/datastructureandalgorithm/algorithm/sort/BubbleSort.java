package com.github.datastructureandalgorithm.algorithm.sort;

import com.github.datastructureandalgorithm.algorithm.util.SwapUtils;

public class BubbleSort {

    private BubbleSort(){}

    public static <T extends Comparable> void sort(T[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - 1 - i; j++)
                if (arr[j].compareTo(arr[j + 1]) > 0)
                    SwapUtils.swap(arr, j, j + 1);
    }
}
