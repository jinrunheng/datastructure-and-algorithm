package com.github.datastructureandalgorithm.datastructure.SegmentTree;

public class SegmentTree2<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree2(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        tree = (E[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        buildSegmentTree();
    }

    private void buildSegmentTree() {
        for (int i = data.length, j = 0; i < 2 * data.length; i++, j++) {
            tree[i] = data[j];
        }
        for (int i = data.length - 1; i > 0; i--) {
            tree[i] = merger.merge(tree[i * 2], tree[i * 2 + 1]);
        }
    }


    public void update(int index, E val) {
        data[index] = val;
        index += data.length;
        tree[index] = val;
        while (index > 0) {
            int leftIndex = index;
            int rightIndex = index;
            if (index % 2 == 0) {
                rightIndex = index + 1;
            } else {
                leftIndex = index - 1;
            }
            tree[index / 2] = merger.merge(tree[leftIndex], tree[rightIndex]);
            index /= 2;
        }
    }

    public E query(int l, int r) {
        if (l < 0 || l >= data.length
                || r < 0 || r >= data.length
                || l > r) {
            throw new IllegalArgumentException("Index is illegal");
        }
        l += data.length;
        r += data.length;
        E res = null;
        while (l <= r) {
            if (l % 2 == 1) {
                if (res == null) {
                    res = tree[l];
                } else {
                    res = merger.merge(res, tree[l]);
                }
                l++;
            }
            if (r % 2 == 0) {
                if (res == null) {
                    res = tree[r];
                } else {
                    res = merger.merge(res, tree[r]);
                }
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return res;
    }

}
