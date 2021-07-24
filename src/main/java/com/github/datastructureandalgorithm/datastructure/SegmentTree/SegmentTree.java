package com.github.datastructureandalgorithm.datastructure.SegmentTree;

public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在 treeIndex 的位置创建区间为 [l...r] 的线段树
     *
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = getLeftChildIndex(treeIndex);
        int rightTreeIndex = getRightChildIndex(treeIndex);

        int mid = l + ((r - l) >> 1);
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    /**
     * 获取某个元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");
        return data[index];
    }

    /**
     * 获取线段树中共有多少个元素
     *
     * @return
     */
    public int getSize() {
        return data.length;
    }

    /**
     * 获取线段树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    /**
     * 获取线段树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    /**
     * 查询区间 [queryL,queryR] 的值
     *
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length
                || queryR < 0 || queryR >= data.length
                || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal");

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在 treeIndex 为根的线段树中 [l...r] 的范围里，搜索区间 [queryL...queryR] 的值
     *
     * @param treeIndex
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int mid = l + ((r - l) >> 1);
        int leftTreeIndex = getLeftChildIndex(treeIndex);
        int rightTreeIndex = getRightChildIndex(treeIndex);


        if (queryL > mid) {// 如果查找的区间范围只在右子树中
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR < mid + 1) {// 如果查找的区间范围只在左子树中
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    public void update(int index, E e) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");

        data[index] = e;
        update(0, 0, data.length - 1, index, e);
    }

    /**
     * 在以 treeIndex 为根节点的线段树中，更新 index 的值为 e
     *
     * @param treeIndex
     * @param l
     * @param r
     * @param index
     * @param e
     */
    private void update(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            // 当 l == r 说明，找到了线段树的叶子节点，该节点的值就是 data[index]，更新这个节点
            tree[treeIndex] = e;
            return;
        }

        int leftTreeIndex = getLeftChildIndex(treeIndex);
        int rightTreeIndex = getRightChildIndex(treeIndex);

        int mid = l + ((r - l) >> 1);

        if (index <= mid)
            update(leftTreeIndex, l, mid, index, e);
        else
            update(rightTreeIndex, mid + 1, r, index, e);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                sb.append(tree[i]);
            } else {
                sb.append("null");
            }
            if (i != tree.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
