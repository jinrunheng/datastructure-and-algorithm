package com.github.datastructureandalgorithm.algorithm.sort;

import static com.github.datastructureandalgorithm.algorithm.util.SwapUtils.swap;

/**
 * @Author Dooby Kim
 * @Date 2023/2/9 5:57 下午
 * @Version 1.0
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapify(arr, i, arr.length);
            // 使用 heapify 可以将操作构建堆的复杂度提升至 O(N)
            // heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }


    // heapInsert arr[index]为刚刚插入的数字
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // heapify arr[index]能否往下沉
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = 0;
            // 两个孩子中，谁的值大，把下标给largest
            // 如果有右孩子
            if (left + 1 < heapSize) {
                largest = arr[left + 1] > arr[left] ? left + 1 : left;
            } else {
                // 如果没有右孩子
                largest = left;
            }

            // 父节点和较大的孩子之间，谁的值大，就将下表给largest
            largest = arr[largest] > arr[index] ? largest : index;
            // 如果父节点最大，那么就退出循环
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }
}
