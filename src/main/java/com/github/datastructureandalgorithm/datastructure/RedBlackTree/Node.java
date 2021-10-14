package com.github.datastructureandalgorithm.datastructure.RedBlackTree;

public class Node<E> {

    public E e;
    public Node left;
    public Node right;
    public boolean color;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public Node(E e) {
        this.e = e;
        left = null;
        right = null;
        color = RED;
    }
}
