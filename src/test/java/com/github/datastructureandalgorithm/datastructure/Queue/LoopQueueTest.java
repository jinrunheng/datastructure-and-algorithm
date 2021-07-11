package com.github.datastructureandalgorithm.datastructure.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoopQueueTest {

    @Test
    void getCapacity() {
        LoopQueue<Integer> queue = new LoopQueue<>();
        Assertions.assertEquals(queue.getCapacity(), 10);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.enqueue(1);
        Assertions.assertEquals(queue.getCapacity(), 20);
    }

    @Test
    void enqueue() {
        LoopQueue<Integer> queue = new LoopQueue<>();
        queue.enqueue(1);
        Assertions.assertEquals(queue.getSize(), 1);
    }

    @Test
    void dequeue() {
        LoopQueue<Integer> queue = new LoopQueue<>();
        queue.enqueue(1);
        Assertions.assertEquals(queue.getSize(), 1);
        Integer e = queue.dequeue();
        Assertions.assertEquals(e, 1);
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    void getFront() {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        Assertions.assertEquals(queue.getFront(), 0);
        queue.dequeue();
        Assertions.assertEquals(queue.getFront(), 1);
    }

    @Test
    void getSize() {
        LoopQueue<Integer> queue = new LoopQueue<>();
        queue.enqueue(1);
        Assertions.assertEquals(queue.getSize(), 1);
        queue.enqueue(2);
        Assertions.assertEquals(queue.getSize(), 2);
    }

    @Test
    void isEmpty() {
        LoopQueue<Integer> queue = new LoopQueue<>();
        Assertions.assertTrue(queue.isEmpty());
        queue.enqueue(1);
        Assertions.assertFalse(queue.isEmpty());
    }

    @Test
    void testToString() {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        // LoopQueue size:9,capacity:10
        // front[1, 2, 3, 4, 5, 6, 7, 8, 9]tail
        System.out.println(queue.toString());
    }

    @Test
    void resize() {
        LoopQueue<Integer> queue = new LoopQueue<>(5);
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        Assertions.assertEquals(queue.getCapacity(), 5);
        queue.enqueue(100);
        Assertions.assertEquals(queue.getCapacity(),10);
        for(int i = 0; i < 4; i++){
            queue.dequeue();
        }
        Assertions.assertEquals(queue.getCapacity(),5);
    }
}