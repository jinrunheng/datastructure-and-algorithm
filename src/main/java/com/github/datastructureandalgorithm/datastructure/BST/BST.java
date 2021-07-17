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
        root = add(e, root);
    }

    /**
     * @param e    向二分搜索树中新插入的节点
     * @param node 当前比较的节点
     * @return 返回二分搜索树的根节点
     */
    private Node add(E e, Node node) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(e, node.left);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(e, node.right);
        }
        return node;
    }
}
