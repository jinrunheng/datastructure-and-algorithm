package com.github.datastructureandalgorithm.datastructure.Stack;

public interface Stack<E> {
    /**
     * 向栈中添加元素
     * @param e
     */
    void push(E e);

    /**
     * 将栈顶元素出栈
     * @return 栈顶元素
     */
    E pop();

    /**
     *
     * @return 当前栈顶元素
     */
    E peek();

    /**
     *
     * @return 栈中共有多少个元素
     */
    int getSize();

    /**
     *
     * @return 当前栈是否为空
     */
    boolean isEmpty();
}
