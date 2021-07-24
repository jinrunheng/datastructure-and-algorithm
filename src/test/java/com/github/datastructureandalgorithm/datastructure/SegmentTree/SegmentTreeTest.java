package com.github.datastructureandalgorithm.datastructure.SegmentTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SegmentTreeTest {

    @Test
    void get() {
    }

    @Test
    void getSize() {
    }

    @Test
    void testToString() {
        Integer[] nums = {0,-3,-3,1,1,2};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Integer::sum);
        Integer query = segmentTree.query(4,5);
        System.out.println(query);
        System.out.println(segmentTree.toString());
    }

    @Test
    void buildSegmentTree() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Integer::sum);
        System.out.println(segmentTree);
    }

    @Test
    void query(){
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Integer::sum);
        Integer result = segmentTree.query(2, 5);
        Assertions.assertEquals(result,-1);
    }

}