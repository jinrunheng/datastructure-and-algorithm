package com.github.datastructureandalgorithm.graph.chapter11;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    @Test
    void test(){
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(3);
        pq.offer(2);
        pq.offer(1);

        while(!pq.isEmpty())
            System.out.println(pq.poll());
    }
}
