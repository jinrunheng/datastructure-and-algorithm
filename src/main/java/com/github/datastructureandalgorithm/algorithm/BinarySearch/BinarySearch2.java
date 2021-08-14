package com.github.datastructureandalgorithm.algorithm.BinarySearch;

public class BinarySearch2 {

    private BinarySearch2() {
    }

    /**
     * 修改循环不变量的定义：在 data[l,r) 的范围中使用二分查找法寻找 target
     *
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0, r = data.length;

        while (l < r) {
            int mid = l + ((r - l) >> 1);

            if (target.compareTo(data[mid]) == 0)
                return mid;
            else if (target.compareTo(data[mid]) > 0)
                l = mid + 1; // 继续在 data[mid + 1,r) 范围里继续寻找解
            else
                r = mid; // 继续在 data[l,mid) 范围里寻找解
        }
        return -1;
    }
}
