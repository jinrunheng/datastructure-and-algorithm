package com.github.datastructureandalgorithm.datastructure.BST;

public class Node<E> {
    public E e;
    public Node left;
    public Node right;

    public Node(E e) {
        this.e = e;
        left = null;
        right = null;
    }
}
