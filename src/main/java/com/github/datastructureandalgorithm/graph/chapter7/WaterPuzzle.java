package com.github.datastructureandalgorithm.graph.chapter7;


import java.util.*;

/**
 * WaterPuzzle 问题：
 * 有两个没有刻度的桶，一个可以盛装 5 升的水，一个可以盛装 3 升的水，问：如何利用这两个桶得到 4 升水？
 */
public class WaterPuzzle {
    private int end = -1;
    private boolean[] visited;
    private int[] pre;

    public WaterPuzzle() {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[100];
        pre = new int[100];
        q.offer(0);
        visited[0] = true;
        pre[0] = 0;


        while (!q.isEmpty()) {
            int cur = q.poll();
            int x = cur / 10;
            int y = cur % 10;
            List<Integer> nexts = getNexts(x, y);

            for (int next : nexts)
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    pre[next] = cur;
                    if (next / 10 == 4 || next % 10 == 4) {
                        end = next;
                        return;
                    }
                }
        }
    }

    private List<Integer> getNexts(int x, int y) {
        List<Integer> nexts = new ArrayList<>();
        nexts.add(5 * 10 + y);
        nexts.add(x * 10 + 3);
        nexts.add(0 * 10 + y);
        nexts.add(x * 10 + 0);
        // x = 5 y = 2   3 - y
        // x = 1 y = 0   x
        int x2y = Math.min(x, 3 - y);
        nexts.add((x - x2y) * 10 + y + x2y);

        // x = 4 y = 3   5 - x
        // x = 0 y = 3   y
        int y2x = Math.min(5 - x, y);
        nexts.add((x + y2x) * 10 + y - y2x);
        return nexts;
    }

    public Iterable<Integer> result() {
        List<Integer> res = new ArrayList<>();
        if (end == -1) return res;
        int cur = end;
        while (cur != 0) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(0);
        Collections.reverse(res);
        return res;
    }
}
