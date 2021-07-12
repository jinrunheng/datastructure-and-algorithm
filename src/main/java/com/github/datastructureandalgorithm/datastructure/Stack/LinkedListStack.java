package com.github.datastructureandalgorithm.datastructure.Stack;

import com.github.datastructureandalgorithm.datastructure.LinkedList.LinkedList;

/**
 * 使用链表这种数据结构作为底层实现的栈
 * 链表头作为栈顶，链表尾作为栈底
 *
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    /**
     * @param e 压栈元素 e
     */
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    /**
     * @return 出栈元素
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }

    /**
     * @return 查看当前栈顶元素
     */
    @Override
    public E peek() {
        return list.getFirst();
    }

    /**
     * @return 当前栈的元素个数
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * @return 当前栈是否为空
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack:\n");
        for (int i = 0; i < getSize(); i++) {
            sb.append("[" + list.get(i) + "]\n");
        }
        return sb.toString();
    }
}
