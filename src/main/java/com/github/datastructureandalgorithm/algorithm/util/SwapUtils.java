package com.github.datastructureandalgorithm.algorithm.util;

public class SwapUtils {
    public static void swap(int[] arr, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        if (i == j || arr[i] == arr[j]) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
