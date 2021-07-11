package com.github.datastructureandalgorithm.datastructure.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayQueueTest {

    @Test
    void enqueue() {
        Queue<Integer> queue = new ArrayQueue<>();
        Assertions.assertTrue(queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assertions.assertEquals(queue.getSize(), 3);
        Assertions.assertEquals(queue.getFront(), 1);
    }

    @Test
    void dequeue() {
        Queue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(1);
        Integer e = queue.dequeue();
        Assertions.assertEquals(e, 1);
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    void getFront() {
        Queue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(1);
        Assertions.assertEquals(queue.getFront(), 1);
    }

    @Test
    void getSize() {
        Queue<Integer> queue = new ArrayQueue<>();
        Assertions.assertEquals(queue.getSize(), 0);
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        Assertions.assertEquals(queue.getSize(), 20);
    }

    @Test
    void isEmpty() {
        Queue<Integer> queue = new ArrayQueue<>();
        Assertions.assertTrue(queue.isEmpty());
        queue.enqueue(1);
        Assertions.assertFalse(queue.isEmpty());
    }

    @Test
    void testToString() {
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        // Queue:
        // front:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9] tail
        System.out.println(queue.toString());
    }
}