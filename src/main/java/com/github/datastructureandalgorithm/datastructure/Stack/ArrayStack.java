package com.github.datastructureandalgorithm.datastructure.Stack;

import com.github.datastructureandalgorithm.datastructure.dynamic_array.Array;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    /**
     *
     * @return 栈的底层实现的动态数组的容量大小
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * @param e 压入栈的元素
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * @return 出栈的元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * @return 当前栈顶的元素
     */
    @Override
    public E peek() {
        return array.get(array.getSize() - 1);
    }

    /**
     * @return 栈中共有多少个元素
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     *
     * @return 栈是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
}
