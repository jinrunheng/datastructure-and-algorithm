package com.github.datastructureandalgorithm.datastructure.Map;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class MapPerformanceTest {

    private static List<String> generateTestList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            String s = UUID.randomUUID().toString();
            list.add(s);
            if (i % 3 == 0) {
                int random = new Random().nextInt(list.size());
                list.add(list.get(random));
            }
        }
        return list;
    }

    private static double testMap(Map<String, Integer> map, List<String> list) {
        long startTime = System.nanoTime();
        for (String word : list) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    void performanceTest() {
        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        List<String> words = generateTestList();
        double time1 = testMap(linkedListMap, words);
        System.out.println("LinkedListMap : " + time1 + " s");
        double time2 = testMap(bstMap, words);
        System.out.println("BSTMap : " + time2 + " s");
    }
}
