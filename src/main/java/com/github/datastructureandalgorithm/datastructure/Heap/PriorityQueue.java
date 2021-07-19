package com.github.datastructureandalgorithm.datastructure.Heap;

import com.github.datastructureandalgorithm.datastructure.Queue.Queue;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    /**
     * @param e 入队元素
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     * @return 将优先队列的队首元素出队
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    /**
     * @return 获取优先队列的队首元素
     */
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    /**
     * @return 获取优先级队列中的元素个数
     */
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    /**
     * @return 返回当前优先队列元素个数是否为空
     */
    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
