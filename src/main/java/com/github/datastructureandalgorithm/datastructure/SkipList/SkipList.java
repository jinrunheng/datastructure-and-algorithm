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
        public Node<E>[] next;

        public Node(int level) {
            next = new Node[level];
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{ e : " + e + " , level : " + next.length + " }");
            return sb.toString();
        }
    }

    // 跳表的最大层数为 16 层
    private final int MAX_LEVEL = 16;
    // 当前跳表出现过的最大的“索引高度”
    private int maxLevel = 1;
    // 跳表元素的个数
    private int size = 0;

    private Node<E> head = new Node<>(MAX_LEVEL);
    private Random random = new Random();

    /**
     * @param e
     * @return 跳表中是否包含值为 val 的节点
     */
    public boolean contains(E e) {
        Node cur = head;
        for (int i = maxLevel - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].e.compareTo(e) < 0) {
                cur = cur.next[i];
            }
            if (cur.next[i] != null && cur.next[i].e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param e 向跳表中添加一个元素 e
     */
    public void add(E e) {
        if (contains(e)) {
            throw new IllegalArgumentException("Add Failed! This element already exists");
        }

        int level = generateRandomLevel();
        // 更新当前跳表的 maxLevel
        if (level > maxLevel) {
            maxLevel = level;
        }
        Node<E> newNode = new Node<>(level);
        newNode.e = e;


        Node cur = head;
        for (int i = maxLevel - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].e.compareTo(e) < 0) {
                cur = cur.next[i];
            }
            if (level > i) {
                if (cur.next[i] == null) {
                    cur.next[i] = newNode;
                } else {
                    Node next = cur.next[i];
                    cur.next[i] = newNode;
                    newNode.next[i] = next;
                }
            }
        }

        size++;
    }

    /**
     * @param e 从跳表中删除元素 e
     */
    public void remove(E e) {
        if (!contains(e)) {
            throw new IllegalArgumentException("Remove Failed! There is no such element: " + e + " in SkipList.");
        }
        Node<E>[] update = new Node[maxLevel];
        Node cur = head;
        for (int i = maxLevel - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].e.compareTo(e) < 0) {
                cur = cur.next[i];
            }
            update[i] = cur;
        }
        if (cur.next[0] != null && cur.next[0].e.equals(e)) {
            for (int i = maxLevel - 1; i >= 0; i--) {
                if (update[i].next[i] != null && update[i].next[i].e.equals(e)) {
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
            // 更新当前跳表的 maxLevel
            while (maxLevel > 1 && head.next[maxLevel] == null) {
                maxLevel--;
            }
        }
        size--;
    }

    /**
     * @return 返回一个 1 ~ MAX_LEVEL 之间的随机数字；
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

    /**
     * 打印输出跳表中的所有元素
     */
    public void printAllElement() {
        Node cur = head;
        while (cur.next[0] != null) {
            System.out.print(cur.next[0] + " ");
            cur = cur.next[0];
        }
        System.out.println();
    }
}
