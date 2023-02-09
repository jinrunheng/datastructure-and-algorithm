package com.github.datastructureandalgorithm.algorithm.sort;

import com.github.datastructureandalgorithm.algorithm.util.SwapUtils;

import java.util.Random;

import static com.github.datastructureandalgorithm.algorithm.util.SwapUtils.swap;

public class QuickSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // 改进的部分，让原本固定在最后的partition划分值 变成了随机位置
            swap(arr, r, l + new Random().nextInt(r - l + 1));
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[0] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int cur = l;
        int less = l - 1;
        int more = r;
        // 每次都以arr[r]作为partition的划分值
        while (cur < more) {
            if (arr[cur] < arr[r]) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > arr[r]) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }
}
