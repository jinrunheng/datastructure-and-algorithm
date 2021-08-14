package com.github.datastructureandalgorithm.algorithm.BinarySearch;

public class BinarySearch {
    private BinarySearch() {
    }

    /**
     * 返回 target 在已序数组 data 中的索引，如果没有则返回 -1
     *
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int search(E[] data, E target) {
        return search(data, 0, data.length - 1, target);
    }

    private static <E extends Comparable<E>> int search(E[] data, int l, int r, E target) {
        if (l > r)
            return -1;

        int mid = l + ((r - l) >> 1);

        if (data[mid].compareTo(target) == 0)
            return mid;
        if (target.compareTo(data[mid]) > 0)
            return search(data, mid + 1, r, target);

        return search(data, l, mid - 1, target);
    }
}
