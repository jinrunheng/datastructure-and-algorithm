package com.github.datastructureandalgorithm.datastructure.HuffmanTree;

import java.util.*;

public class HuffmanTree {
    /**
     * @param list 传入所有节点的 list
     * @return 返回生成的哈夫曼树的根
     */
    public static Node createHuffmanTree(List<Node> list) {
        while (list.size() > 1) {
            Collections.sort(list);
            // 获取权值最小的两个节点
            Node left = list.get(0);
            Node right = list.get(1);
            // 生成新节点，新节点的权值为两个子节点权值的和
            Node parent = new Node(null, left.weight + right.weight, left, right);
            // 删除权值最小的两个节点
            list.remove(0);
            list.remove(0);
            // 将新的节点添加到 list 中
            list.add(parent);
        }
        return list.get(list.size() - 1);
    }

    /**
     * 哈夫曼树的广度优先遍历
     *
     * @param root
     * @return
     */
    public static List<Node> levelOrder(Node root) {
        List<Node> ret = new ArrayList<>();
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                root = queue.poll();
                ret.add(root);
                if (root.left != null)
                    queue.offer(root.left);
                if (root.right != null)
                    queue.offer(root.right);
            }
        }
        return ret;
    }

    public static double getWPL(Node root) {
        double ret = 0.0;
        int level = 0;
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    root = queue.poll();
                    if (root.e != null) {
                        ret += root.weight * level;
                    }
                    if (root.left != null)
                        queue.offer(root.left);
                    if (root.right != null)
                        queue.offer(root.right);
                }
                level++;
            }
        }
        return ret;
    }
}
