package com.github.datastructureandalgorithm.algorithm.util;

import com.github.datastructureandalgorithm.datastructure.BST.Node;

import java.util.Stack;

public class TreeUtils {

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
}
