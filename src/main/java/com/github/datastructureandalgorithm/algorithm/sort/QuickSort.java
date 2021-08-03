package com.github.datastructureandalgorithm.algorithm.sort;

import com.github.datastructureandalgorithm.algorithm.util.SwapUtils;

public class QuickSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l < r) {
            // 让任意位置的数与基准数arr[r]调换,保证算法的随机性
            SwapUtils.swap(arr, l + (int) ((r - l + 1) * Math.random()), r);
            int[] t = partition(arr, l, r);
            sort(arr, l, t[0] - 1);
            sort(arr, t[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int p1 = l - 1;
        int p2 = r;
        int cur = l;
        while (cur < p2) {
            if (arr[cur] < arr[r])
                SwapUtils.swap(arr, cur++, ++p1);
            else if (arr[cur] > arr[r])
                SwapUtils.swap(arr, cur, --p2);
            else
                cur++;
        }
        SwapUtils.swap(arr, p2, r);
        return new int[]{++p1, --p2};
    }
}
