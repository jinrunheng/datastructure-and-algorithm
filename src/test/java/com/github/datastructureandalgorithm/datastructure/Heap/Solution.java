package com.github.datastructureandalgorithm.datastructure.Heap;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 347:https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
class Solution {
    private class Freq {
        int e;
        int freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        java.util.PriorityQueue<Freq> priorityQueue = new java.util.PriorityQueue<>((o1, o2) -> {
            if (o1.freq > o2.freq) {
                return 1;
            } else if (o1.freq < o2.freq) {
                return -1;
            } else {
                return 0;
            }
        });
        for (int key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(new Freq(key, map.get(key)));
            } else if (map.get(key) > priorityQueue.peek().freq) {
                priorityQueue.remove();
                priorityQueue.offer(new Freq(key, map.get(key)));
            }
        }
        int[] res = new int[priorityQueue.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = priorityQueue.remove().e;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testData = new int[]{4, 1, -1, 2, -1, 2, 3};
        int[] ints = solution.topKFrequent(testData, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
