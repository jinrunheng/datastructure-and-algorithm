package com.github.datastructureandalgorithm.datastructure.BST;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param e 向二分搜索树中添加新的元素
     */
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(e, root);
        }
    }

    /**
     * @param e    向二分搜索树中添加新的元素
     * @param node 当前的比较的节点
     */
    private void add(E e, Node node) {

        // if e < root.e,then go left;else go right
        if (e.compareTo(node.e) == 0) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0) {
            add(e, node.left);
        } else {
            add(e, node.right);
        }
    }
}
