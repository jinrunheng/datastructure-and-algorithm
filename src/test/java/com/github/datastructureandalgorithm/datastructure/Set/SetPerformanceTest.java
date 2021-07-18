package com.github.datastructureandalgorithm.datastructure.Set;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SetPerformanceTest {

    private static List<String> generateTestList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            String s = UUID.randomUUID().toString();
            list.add(s);
            if (i % 3 == 0) {
                list.add(list.get(list.size() - 1));
            }
        }
        return list;
    }

    private static double testSet(Set<String> set, List<String> strings) {
        long startTime = System.nanoTime();
        for (String s : strings) {
            set.add(s);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    void performanceTest() {
        List<String> strings = generateTestList();
        BSTSet<String> bstSet = new BSTSet<>();
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time1 = testSet(bstSet, strings);
        System.out.println("BST Set : " + time1 + " s");
        double time2 = testSet(linkedListSet, strings);
        System.out.println("LinkedList Set : " + time2 + " s");
    }

}
