package com.github.datastructureandalgorithm.datastructure.Queue;

public interface Queue<E> {
    /**
     * @param e 入队元素
     */
    void enqueue(E e);

    /**
     * @return 从队列中将队首元素出队
     */
    E dequeue();

    /**
     * @return 获取队列对首元素
     */
    E getFront();

    /**
     * @return 队列中共有多少个元素
     */
    int getSize();

    /**
     * @return 当前队列是否为空
     */
    boolean isEmpty();
}
