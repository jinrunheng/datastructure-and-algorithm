package com.github.datastructureandalgorithm.datastructure.SegmentTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SegmentTree2Test {

    @Test
    void update() {
        Integer[] arr = {2,3,5,-1,6,8,7,0,-2};
        SegmentTree2<Integer> segmentTree2 = new SegmentTree2<>(arr,Integer::sum);
        Assertions.assertEquals(28,segmentTree2.query(0,8));
    }

    @Test
    void query() {
    }
}