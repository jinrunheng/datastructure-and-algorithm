package com.github.datastructureandalgorithm.datastructure.Map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    /**
     * @param k 键 k
     * @param v 值 v
     *          向二分搜索树中添加新的元素(k,v)
     */
    @Override
    public void add(K k, V v) {
        root = add(root, k, v);
    }

    private Node add(Node node, K k, V v) {
        if (node == null) {
            size++;
            return new Node(k, v);
        }
        if (k.compareTo(node.key) < 0) {
            node.left = add(node.left, k, v);
        } else if (k.compareTo(node.key) > 0) {
            node.right = add(node.right, k, v);
        } else {
            node.value = v;
        }
        return node;
    }

    /**
     * @param node
     * @param key
     * @return 返回以 node 为根节点的二分搜索树中，key 所在的节点
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    /**
     * @param k
     * @return 删除映射中键为 k 的节点，并返回该节点的值
     */
    @Override
    public V remove(K k) {
        Node node = getNode(root, k);
        if (node != null) {
            root = remove(k, root);
            return node.value;
        }
        return null;
    }

    private Node remove(K k, Node node) {
        if (node == null) {
            return null;
        }
        if (k.compareTo(node.key) < 0) {
            node.left = remove(k, node.left);
            return node;
        } else if (k.compareTo(node.key) > 0) {
            node.right = remove(k, node.right);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // Hibbard Deletion
            Node successor = minimum(node.right);
            Node right = removeMin(node.right);
            Node left = node.left;
            successor.left = left;
            successor.right = right;
            node.left = null;
            node.right = null;
            return successor;
        }
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * @param k
     * @return 二分搜索树作为底层的映射中是否含有 键为 k 的节点
     */
    @Override
    public boolean contains(K k) {
        return getNode(root, k) != null;
    }

    /**
     * @param k
     * @return 获取二分搜索树作为底层的映射键为 k 的节点的值 value
     */
    @Override
    public V get(K k) {
        Node node = getNode(root, k);
        return node == null ? null : node.value;
    }

    /**
     * @param k
     * @param v 将映射中，键为 k 的节点的值设置为 v；如果当前映射中没有这个节点，则抛出异常
     */
    @Override
    public void set(K k, V v) {
        Node node = getNode(root, k);
        if (node == null) {
            throw new IllegalArgumentException(k + "doesn't exist!");
        }
        node.value = v;
    }

    /**
     * @return 获取映射中元素的个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * @return 映射是否为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
