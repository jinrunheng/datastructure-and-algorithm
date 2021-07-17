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

    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * @param node 中序遍历以 node 为 根的二分搜索树
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e + " ");
        inOrder(node.right);
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * @param node 后序遍历以 node 为 根的二分搜索树
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e + " ");
    }

    /**
     * @return 返回二分搜索树的最小元素
     */
    public E minimum() {
        if (size == 0) {
            throw new RuntimeException("BST is empty");
        }
        return (E) minimum(root).e;
    }

    /**
     * @param node 返回以 node 为根的二分搜索树的最小值所在的节点
     * @return 返回以 node 为根的二分搜索树的最小值所在的节点
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * @return 返回二分搜索树的最大元素
     */
    public E maximum() {
        if (size == 0) {
            throw new RuntimeException("BST is empty");
        }
        return (E) maximum(root).e;
    }

    /**
     * @param node 返回以 node 为根的二分搜索树的最大值所在的节点
     * @return 返回以 node 为根的二分搜索树的最大值所在的节点
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * @return 从二叉搜索树中删除最小值所在的节点，返回最小值
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * @param node 删除掉以 node 为根的二分搜索树中的最小节点
     * @return 返回删除节点后新的二分搜索树的根
     */
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
     * @return 从二叉搜索树中删除最大值所在的节点，返回最大值
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * @param node 删除掉以 node 为根的二分搜索树中的最大节点
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node removeMax(Node node){
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }
}
