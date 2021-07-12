package com.github.datastructureandalgorithm.datastructure.LinkedList;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * @return 链表中元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * @return 当前链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param e     向链表中插入的元素
     * @param index 向链表中插入的位置（索引）
     */
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Insert failed.Index is illegal.");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;
    }

    /**
     * 在链表头部添加新的元素 e
     *
     * @param e 添加的元素
     */
    public void addFirst(E e) {
        add(e, 0);
    }

    /**
     *
     * 在链表尾部添加新的元素 e
     *
     * @param e 添加的元素
     */
    public void addLast(E e) {
        add(e, size);
    }


}
