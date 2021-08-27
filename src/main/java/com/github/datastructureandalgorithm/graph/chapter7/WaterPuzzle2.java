package com.github.datastructureandalgorithm.graph.chapter7;

import java.util.*;

public class WaterPuzzle2 {
    private int end = -1;
    private boolean[] visited;
    private int[] pre;

    public WaterPuzzle2() {
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
                    if (next / 10 == 6 || next % 10 == 6) {
                        end = next;
                        return;
                    }
                }
        }
    }

    private List<Integer> getNexts(int x, int y) {
        List<Integer> nexts = new ArrayList<>();
        nexts.add(9 * 10 + y);
        nexts.add(x * 10 + 4);
        nexts.add(0 * 10 + y);
        nexts.add(x * 10 + 0);
        // x = 9 y = 2   -> x = 7 y = 4
        // x = 1 y = 0   -> x = 0 y = 1
        int x2y = Math.min(x, 4 - y);
        nexts.add((x - x2y) * 10 + y + x2y);

        // x = 8 y = 3   -> x = 9 y = 2
        // x = 0 y = 3   -> x = 3 y = 0
        int y2x = Math.min(9 - x, y);
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

    public static void main(String[] args) {
        WaterPuzzle2 waterPuzzle2 = new WaterPuzzle2();
        System.out.println(waterPuzzle2.result());
    }
}
