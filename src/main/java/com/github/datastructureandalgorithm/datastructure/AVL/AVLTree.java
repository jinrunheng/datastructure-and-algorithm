package com.github.datastructureandalgorithm.datastructure.AVL;

import java.util.ArrayList;
import java.util.List;

/**
 * 注释中有图，请勿格式化代码
 */
public class AVLTree<E extends Comparable<E>> {
    private Node root;
    private int size;

    public AVLTree() {
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
     * 返回 node 节点的高度
     *
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    /**
     * 获得节点 node 的平衡因子
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * @return 返回 AVL 的根节点
     */
    public Node getRoot() {
        return root;
    }

    /**
     * @param e 向 AVL 中添加新的元素
     */
    public void add(E e) {
        root = add(e, root);
    }

    /**
     * @param e    向 AVL 中新插入的节点
     * @param node 当前比较的节点
     * @return 返回 AVL 的根节点
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

        // 更新 height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);

        // 平衡的维护

        // LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
            return rightRotate(node);

        // RR
        if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
            return leftRotate(node);

        // LR
        if(balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if(balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    /**
     * 右旋转:
     *
     *            y                           x
     *          /  \                       /     \
     *        x    T4                    z        y
     *      /  \         ========>     /  \     /  \
     *    z     T3                   T1   T2  T3   T4
     *  /  \
     * T1  T2
     */
    private Node rightRotate(Node y){
        Node x = y.left;
        Node T3 = x.right;
        x.right = y;
        y.left = T3;

        // 更新 height
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;
        return x;
    }

    /**
     * 左旋转:
     *
     *            y                           x
     *          /  \                       /     \
     *        T4    x                    y        z
     *             /  \    ========>   /  \     /  \
     *            T3   z             T4   T3  T1   T2
     *               /  \
     *              T1  T2
     */
    private Node leftRotate(Node y){
        Node x = y.right;
        Node T3 = x.left;
        x.left = y;
        y.right = T3;

        // 更新 height
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;

        return x;
    }

    /**
     * @param e 查找的元素 e
     * @return 返回当前 AVL 中是否包含元素 e
     */
    public boolean contains(E e) {
        return contains(e, root);
    }

    /**
     * @param e    查找的元素 e
     * @param node 当前比较的节点
     * @return 返回当前 AVL 中是否包含元素 e
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
     * 验证当前的 AVL 树是否满足二分搜索树的特性
     *
     * @return
     */
    public boolean isBST() {
        ArrayList<E> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 1; i < list.size(); i++)
            if (list.get(i - 1).compareTo(list.get(i)) > 0)
                return false;
        return true;
    }

    /**
     * @param node 中序遍历以 node 为 根的 AVL
     */
    private void inOrder(Node node, List<E> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add((E) node.e);
        inOrder(node.right, list);
    }

    /**
     * 验证当前的二叉树是否是一棵平衡的二叉树
     *
     * @return
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * 验证当前的二叉树是否是一棵平衡的二叉树
     *
     * @param node
     * @return
     */
    private boolean isBalanced(Node node) {
        if (node == null)
            return true;
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1)
            return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }

    /**
     * @return 返回 AVL 的最小元素
     */
    public E minimum() {
        if (size == 0) {
            throw new RuntimeException("BST is empty");
        }
        return (E) minimum(root).e;
    }

    /**
     * @param node 返回以 node 为根的 AVL 的最小值所在的节点
     * @return 返回以 node 为根的 AVL 的最小值所在的节点
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * @return 返回 AVL 的最大元素
     */
    public E maximum() {
        if (size == 0) {
            throw new RuntimeException("AVL is empty");
        }
        return (E) maximum(root).e;
    }

    /**
     * @param node 返回以 node 为根的 AVL 的最大值所在的节点
     * @return 返回以 node 为根的 AVL 的最大值所在的节点
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public void remove(E e) {
        root = remove(e, root);
    }

    private Node remove(E e, Node node) {
        if (node == null)
            return null;

        Node retNode;
        if (e.compareTo((E) node.e) < 0) {
            node.left = remove(e, node.left);
            retNode = node;
        } else if (e.compareTo((E) node.e) > 0) {
            node.right = remove(e, node.right);
            retNode = node;
        } else {
            // 待删除节点的左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            }
            // 待删除的节点右子树为空时
            else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            }
            // 待删除的节点左右子树均不为空
            else {// Hibbard Deletion
                Node successor = minimum(node.right);
                Node right = remove((E) node.right, successor);
                Node left = node.left;
                successor.left = left;
                successor.right = right;
                node.left = null;
                node.right = null;
                return successor;
            }
        }

        if(retNode == null)
            return null;

        // 更新 height
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);

        // 平衡的维护

        // LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0)
            return rightRotate(retNode);

        // RR
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)
            return leftRotate(retNode);

        // LR
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }

        // RL
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
    }
}
