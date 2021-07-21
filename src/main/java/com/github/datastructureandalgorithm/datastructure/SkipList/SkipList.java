package com.github.datastructureandalgorithm.datastructure.SkipList;

import java.util.Random;

public class SkipList<E extends Comparable<E>> {

    class Node<E extends Comparable<E>> {
        public E e;
        public Node<E> next[];

        public Node(int level) {
            next = new Node[level];
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{ e : " + e + " , levels : " + next.length + " }");
            return sb.toString();
        }
    }

    // 跳表层数为 32 层
    private final int MAX_LEVEL = 32;
    // 当前跳表节点最大的层数
    private int level = 0;

    private Node<E> dummyHead = new Node<>(MAX_LEVEL);
    private Random random = new Random();

    /**
     * @param val
     * @return 跳表中是否包含值为 val 的节点
     */
    public boolean contains(int val) {
        Node node = dummyHead;
        for (int i = level; i >= 0; i--) {
            while (node.next != null && node.next[i].e.compareTo(val) < 0) {
                node = node.next[i];
            }
            if (node.next[i].e.equals(val)) {
                return true;
            }
        }
        return false;
    }

}
