package com.github.datastructureandalgorithm.datastructure.RedBlackTree;

public class Node<E> {

    public E e;
    public Node left;
    public Node right;
    public boolean color;


    public Node(E e) {
        this.e = e;
        left = null;
        right = null;
        color = true; // true 表示红色，false 表示黑色
    }
}
