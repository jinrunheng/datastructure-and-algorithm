package com.github.datastructureandalgorithm.datastructure.SegmentTree;

public interface Merger<E> {
    E merge(E a, E b);
}
