package com.github.datastructureandalgorithm.datastructure.Queue;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class ArrayQueueAndLoopQueuePerformanceTest {

    /**
     * @param queue   测试的队列
     * @param opCount 测试数据的数量级
     * @return 运行 testQueue 方法所需要的时间
     */
    private static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    void performanceTest() {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue time : " + time1 + " s");

        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue time : " + time2 + " s");
    }

}
