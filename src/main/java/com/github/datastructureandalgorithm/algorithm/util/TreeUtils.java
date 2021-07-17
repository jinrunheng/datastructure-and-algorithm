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
     * @param node 以 node 为根节点，按层打印二叉树
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
     * @param node 获取以 node 为根，二叉树的高度
     * @return
     */
    public static int getTreeDepth(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getTreeDepth(node.left), getTreeDepth(node.right));
    }


    public static void printTree(Node root) {
        List<List<String>> tree = getTreeLevelByList(root);
        for (List<String> list : tree) {
            for (String node : list) {
                System.out.print(node);
            }
            System.out.println();
        }
    }

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
                list.add(" ");
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
