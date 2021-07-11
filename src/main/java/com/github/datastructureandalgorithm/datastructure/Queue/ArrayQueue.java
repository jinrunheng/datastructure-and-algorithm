package com.github.datastructureandalgorithm.datastructure.Queue;

import com.github.datastructureandalgorithm.datastructure.dynamic_array.Array;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * @param e 入队元素
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * @return 出队元素
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * @return 队首元素
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    /**
     * @return 队列大小
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * @return 队列是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue:\n");
        sb.append("front:[");
        for (int i = 0; i < getSize(); i++) {
            sb.append(array.get(i));
            if (i != getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
