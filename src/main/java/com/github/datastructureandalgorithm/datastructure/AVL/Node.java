package com.github.datastructureandalgorithm.datastructure.AVL;

public class Node<E> {
    public E e;
    public Node left;
    public Node right;
    public int height;

    public Node(E e) {
        this.e = e;
        left = null;
        right = null;
        height = 1;
    }
}

