package com.github.datastructureandalgorithm.datastructure.HuffmanTree;

import java.util.*;

public class HuffmanTree {
    /**
     * @param list 传入所有节点的 list
     * @return 返回哈夫曼树的根节点
     */
    public static Node createHuffmanTree(List<Node> list) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < list.size(); i++) {
            queue.offer(list.get(i));
        }
        return createHuffmanTree(queue);
    }

    /**
     * @param queue 按照节点的权值(node.weight) 由小到大维护的优先队列
     * @return 返回哈夫曼树的根节点
     */
    public static Node createHuffmanTree(PriorityQueue<Node> queue) {
        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node parent = new Node(null, left.weight + right.weight, left, right);
            queue.offer(parent);
        }
        return queue.poll();
    }

    /**
     *
     * @param root 传入哈夫曼树的根节点
     * @return 返回带权路径长度 (WPL)
     */
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

    /**
     * 将 Huffman 树所有节点对应的字符转化为 01 编码字符串
     *
     * @param root
     * @return
     */
    public static Map<Character, String> huffmanTreeNodeDataToCode(Node root) {
        Map<Character, String> map = new HashMap<>();
        huffmanTreeNodeDataToCode(root, map, "");
        return map;
    }

    private static void huffmanTreeNodeDataToCode(Node root, Map<Character, String> map, String code) {
        if (root != null) {
            huffmanTreeNodeDataToCode(root.left, map, code + "0");
            if (root.left == null && root.right == null) {
                map.put((Character) root.e, code);
            }
            huffmanTreeNodeDataToCode(root.right, map, code + "1");
        }
    }
}
