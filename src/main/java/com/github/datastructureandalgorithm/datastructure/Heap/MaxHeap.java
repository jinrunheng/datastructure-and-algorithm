package com.github.datastructureandalgorithm.datastructure.Heap;

import com.github.datastructureandalgorithm.algorithm.util.SwapUtils;
import com.github.datastructureandalgorithm.datastructure.dynamic_array.Array;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * @return 返回堆中的元素个数
     */
    public int size() {
        return data.getSize();
    }

    /**
     * @return 返回堆是否为空
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * @param index 孩子节点的索引
     * @return 返回一个索引所表示的元素的父亲节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * @param index 父节点的索引
     * @return 返回一个索引所表示的元素的左孩子节点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * @param index 父节点的索引
     * @return 返回一个索引所表示的元素的右孩子节点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素 e
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int i) {
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0) {
            data.swap(i, parent(i));
            i = parent(i);
        }
    }
}
