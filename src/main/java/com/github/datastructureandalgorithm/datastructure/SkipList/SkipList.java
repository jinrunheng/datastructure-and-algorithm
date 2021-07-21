package com.github.datastructureandalgorithm.datastructure.SkipList;

import java.util.Random;

/**
 * 跳表默认存储的是不重复的元素
 *
 * @param <E>
 */
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
    // 当前跳表出现过的最大的层数
    private int maxLevel = 1;
    // 跳表元素的个数
    private int size = 0;

    private Node<E> dummyHead = new Node<>(MAX_LEVEL);
    private Random random = new Random();

    /**
     * @param e
     * @return 跳表中是否包含值为 val 的节点
     */
    public boolean contains(E e) {
        Node node = dummyHead;
        for (int i = maxLevel - 1; i >= 0; i--) {
            while (node.next != null && node.next[i].e.compareTo(e) < 0) {
                node = node.next[i];
            }
            if (node.next[i].e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public void add(E e) {
        // 如果当前跳表没有任何元素
        dummyHead.next == null ?
    }

    /**
     * @return 返回一个 1 ~ MAX_LEVEL 之间的随机数字；
     * 随机 MAX_LEVEL - 1 次，如果 random.nextInt() 为奇数，则返回值加一
     */
    private int generateRandomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; i++) {
            if (random.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    /**
     * @return 返回当前跳表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return 返回当前跳表中元素的个数
     */
    public int getSize() {
        return size;
    }
}
