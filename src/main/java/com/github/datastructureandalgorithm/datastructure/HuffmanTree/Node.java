package com.github.datastructureandalgorithm.datastructure.HuffmanTree;

public class Node<E> implements Comparable<Node<E>> {
    public E e;
    public double weight;
    public Node<E> left;
    public Node<E> right;

    public Node(E e, double weight, Node<E> left, Node<E> right) {
        this.e = e;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    public Node(E e, Node<E> left, Node<E> right) {
        this(e, 0.0, left, right);
    }

    public Node(E e, double weight) {
        this(e, weight, null, null);
    }

    public Node() {
        this(null, 0.0);
    }

    @Override
    public String toString() {
        return "Node [e = " + e + ",weight = " + weight + "]";
    }


    @Override
    public int compareTo(Node node) {
        return Double.compare(this.weight, node.weight);
    }
}
