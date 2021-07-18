package com.github.datastructureandalgorithm.datastructure.Map;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * @param key 键 key
     * @return 返回映射中键为 key 的节点，如果不存在则返回 null
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * @param k 键 k
     * @param v 值 v
     *          <p>
     *          如果当前映射中没有键为 k 的节点，则在底层的链表头新增一个节点；如果有，则替换节点的 value 值为 v
     *          </p>
     */
    @Override
    public void add(K k, V v) {
        Node node = getNode(k);
        if (node == null) {
            dummyHead.next = new Node(k, v, dummyHead.next);
            size++;
        } else {
            node.value = v;
        }
    }

    /**
     * @param k 键 k
     * @return 从映射中删除键为 k 的节点，并返回节点的 value 值
     */
    @Override
    public V remove(K k) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.key.equals(k)) {
                Node delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
                size--;
                return delNode.value;
            }
            pre = pre.next;
        }
        return null;
    }

    /**
     * @param k 键 k
     * @return 返回当前映射中是否存 k
     */
    @Override
    public boolean contains(K k) {
        return getNode(k) != null;
    }

    /**
     * @param k 键 k
     * @return 返回键为 k 的节点的值，没有则返回 null
     */
    @Override
    public V get(K k) {
        Node node = getNode(k);
        return node == null ? null : node.value;
    }

    /**
     * @param k 键 k
     * @param v 值 v
     *          将映射中键为 k 的节点的值设置为 v
     */
    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
        if (node == null) {
            throw new IllegalArgumentException(k + "doesn't exist!");
        }
        node.value = v;
    }

    /**
     * @return 返回映射中节点的个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * @return 返回映射是否为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
