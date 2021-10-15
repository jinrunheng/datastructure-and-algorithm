package com.github.datastructureandalgorithm.datastructure.RedBlackTree;


public class RBTree<E extends Comparable<E>> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int size;

    public RBTree() {
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
     * 判断节点 node 的颜色
     *
     * @param node
     * @return
     */
    public boolean isRed(Node node) {
        if (node == null)
            return false;
        return node.color;
    }

    /**
     * @return 返回红黑树的根节点
     */
    public Node getRoot() {
        return root;
    }

    /**
     * 左旋转:
     *
     *        node                      x
     *       /   \                    /  \
     *     T1     x    ===========> node T3
     *          /  \               /   \
     *         T2  T3             T1   T2
     *
     */
    private Node leftRotate(Node node){
        Node x = node.right;

        // 左旋转
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 右旋转:
     *
     *        node                       x
     *       /   \                     /  \
     *     x      T2    ===========>  y   node
     *   /  \                            /   \
     *  y   T1                          T1   T2
     *
     */
    private Node rightRotate(Node node) {
        Node x = node.left;

        // 右旋转
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;
        return x;
    }

    // 颜色翻转
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * @param e 向红黑树中添加新的元素
     */
    public void add(E e) {
        root = add(e, root);
        root.color = BLACK;
    }

    /**
     * @param e    向红黑树中新插入的节点
     * @param node 当前比较的节点
     * @return 返回红黑树的根节点
     */
    private Node add(E e, Node node) {
        if (node == null) {
            size++;
            return new Node(e); // 默认插入的是红色节点
        }
        if (e.compareTo((E) node.e) < 0) {
            node.left = add(e, node.left);
        } else if (e.compareTo((E) node.e) > 0) {
            node.right = add(e, node.right);
        }

        if(isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);
        if(isRed(node.left) && isRed(node.left.left))
            rightRotate(node);
        if(isRed(node.left) && isRed(node.right))
            flipColors(node);
        return node;
    }

    /**
     * @param e 查找的元素 e
     * @return 返回当前红黑树中是否包含元素 e
     */
    public boolean contains(E e) {
        return contains(e, root);
    }

    /**
     * @param e    查找的元素 e
     * @param node 当前比较的节点
     * @return 返回当前红黑树中是否包含元素 e
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
}
