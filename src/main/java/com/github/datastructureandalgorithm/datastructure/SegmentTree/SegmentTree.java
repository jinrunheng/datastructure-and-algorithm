package com.github.datastructureandalgorithm.datastructure.SegmentTree;

public class SegmentTree<E> {

    private E[] data;

    public SegmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
    }
}
