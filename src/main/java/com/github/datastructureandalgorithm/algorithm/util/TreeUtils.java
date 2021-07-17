package com.github.datastructureandalgorithm.algorithm.util;

import com.github.datastructureandalgorithm.datastructure.BST.Node;

import java.util.*;

public class TreeUtils {

    /**
     * @param node 前序遍历以 node 为根节点的二叉树
     */
    public static void preOrder(Node node) {
        if (node != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.e + " ");
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            }
        }
    }

    /**
     * @param node 中序遍历以 node 为根节点的二叉树
     */
    public static void inOrder(Node node) {
        if (node != null) {
            Stack<Node> stack = new Stack<>();
            while (node != null || !stack.isEmpty()) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    System.out.println(node.e + " ");
                    node = node.right;
                }
            }
        }
    }

    /**
     * @param node 后序遍历以 node 为根节点的二叉树
     */
    public static void postOrder(Node node) {
        if (node != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(node);
            while (!stack1.isEmpty()) {
                node = stack1.pop();
                stack2.push(node);
                if (node.left != null)
                    stack1.push(node.left);
                if (node.right != null)
                    stack1.push(node.right);
            }
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().e + " ");
            }
        }
    }

    /**
     * @param node 以 node 为根节点，层序遍历二叉树
     */
    public static void levelOrder(Node node) {
        if (node != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(node);
            while (!queue.isEmpty()) {
                node = queue.poll();
                System.out.println(node.e + " ");
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
    }


    /**
     * @param node 获取以 node 为根的二叉树的高度
     * @return
     */
    public static int getTreeDepth(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getTreeDepth(node.left), getTreeDepth(node.right));
    }

    /**
     * 按层打印二叉树
     *
     * @param root 根节点
     */
    public static void printTree(Node root) {
        List<List<String>> tree = getTreeLevelByList(root);
        for (List<String> list : tree) {
            for (String node : list) {
                if (node.equals("")) {
                    System.out.print("  ");
                }
                System.out.print(node);
            }
            System.out.println();
        }
    }

    /**
     * @param root 根节点
     * @return 返回每一层节点的列表
     */
    public static List<List<String>> getTreeLevelByList(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int row = getTreeDepth(root);
        int col = (int) Math.pow(2.0, row) - 1;

        List<List<String>> ret = new ArrayList<>();
        // init
        for (int i = 0; i < row; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                list.add("");
            }
            ret.add(list);
        }
        getRow(ret, root, 0, 0, col);
        return ret;
    }

    private static void getRow(List<List<String>> list, Node root, int row, int left, int right) {
        if (root != null) {
            int mid = (left + right) / 2;
            list.get(row).set(mid, String.valueOf(root.e));
            getRow(list, root.left, row + 1, left, mid);
            getRow(list, root.right, row + 1, mid + 1, right);
        }
    }
}
