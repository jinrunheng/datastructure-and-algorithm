package com.github.datastructureandalgorithm.algorithm.sort;

public class MergeSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int p1 = l;
        int p2 = mid + 1;
        int[] tmp = new int[r - l + 1];

        int i = 0;
        while (p1 <= mid && p2 <= r) {
            tmp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) tmp[i++] = arr[p1++];
        while (p2 <= r) tmp[i++] = arr[p2++];

        for (i = 0; i < tmp.length; i++) {
            arr[l + i] = tmp[i];
        }
    }
}
