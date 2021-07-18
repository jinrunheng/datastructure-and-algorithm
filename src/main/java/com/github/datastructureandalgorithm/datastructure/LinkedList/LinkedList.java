package com.github.datastructureandalgorithm.datastructure.LinkedList;

import java.util.List;

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
     * 在链表尾部添加新的元素 e
     *
     * @param e 添加的元素
     */
    public void addLast(E e) {
        add(e, size);
    }

    /**
     * @param index 获取元素的索引
     * @return 获取 index 位置的节点值
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        return pre.next.e;
    }

    /**
     * @return 获取链表的第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * @return 获取链表的最后一个元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * @param e     更新的元素
     * @param index 更新 index 位置的元素
     */
    public void set(E e, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed.Index is illegal.");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next.e = e;
    }

    /**
     * @param e 查找的元素
     * @return 返回链表中是否有有元素 e
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * @param e 删除链表中的元素 e
     *          此方法只能删除链表中的第一个元素 e
     *          例如：链表为 3->4->5->5->4->NULL
     *          remove(4)
     *          结果为：3->5->5->4->NULL
     */
    public void removeElement(E e) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.e.equals(e)) {
                Node delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
                size--;
                return;
            }
            pre = pre.next;
        }
    }

    /**
     * @param index 删除位置的索引
     * @return 删除的元素值
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node ret = pre.next;
        pre.next = pre.next.next;
        size--;
        ret.next = null;
        return ret.e;
    }

    /**
     * @return 删除链表第一个元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * @return 删除链表最后一个元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.e + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
