package com.github.datastructureandalgorithm.datastructure.BST;

public class BST<E extends Comparable<E>> {

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
     * @return 返回二分搜索树的根节点
     */
    public Node getRoot() {
        return root;
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
        if (e.compareTo((E) node.e) < 0) {
            node.left = add(e, node.left);
        } else if (e.compareTo((E) node.e) > 0) {
            node.right = add(e, node.right);
        }
        return node;
    }

    /**
     * @param e 查找的元素 e
     * @return 返回当前二分搜索树中是否包含元素 e
     */
    public boolean contains(E e) {
        return contains(e, root);
    }

    /**
     * @param e    查找的元素 e
     * @param node 当前比较的节点
     * @return 返回当前二分搜索树中是否包含元素 e
     */
    private boolean contains(E e, Node node) {
        if (node == null) {
            return false;
        }

        if (e.compareTo((E) node.e) == 0) {
            return true;
        } else {
            if (e.compareTo((E) node.e) < 0) {
                return contains(e, node.left);
            } else {
                return contains(e, node.right);
            }
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void proOrder() {
        preOrder(root);
    }

    /**
     * @param node 前序遍历以 node 为 根的二分搜索树
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.e + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

}
