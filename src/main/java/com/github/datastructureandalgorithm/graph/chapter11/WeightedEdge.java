package com.github.datastructureandalgorithm.graph.chapter11;

public class WeightedEdge implements Comparable<WeightedEdge> {
    private int v;
    private int w;
    private int weight;

    public WeightedEdge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("(%d-%d：%d)", v, w, weight);
    }

    @Override
    public int compareTo(WeightedEdge another) {
        return weight - another.weight;
    }
}
