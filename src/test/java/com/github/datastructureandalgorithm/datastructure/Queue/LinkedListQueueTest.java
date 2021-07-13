package com.github.datastructureandalgorithm.datastructure.Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListQueueTest {

    @Test
    void enqueue() {
    }

    @Test
    void dequeue() {
    }

    @Test
    void getFront() {
    }

    @Test
    void getSize() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void testToString() {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for(int i = 0; i < 10; i++){
            linkedListQueue.enqueue(i);
        }
        linkedListQueue.dequeue();
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue.toString());
    }
}