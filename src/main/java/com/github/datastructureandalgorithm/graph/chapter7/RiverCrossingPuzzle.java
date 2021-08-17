package com.github.datastructureandalgorithm.graph.chapter7;

import java.util.*;

/**
 * River Crossing Puzzle:
 * <p>
 * 农夫需要把狼，羊，菜和自己运输到河到对岸去。
 * 只有农夫可以划船，并且船只能承载农夫和另外一样东西。
 * 还有一个棘手的问题是，如果没有农夫看着，羊会偷吃菜，狼会吃羊。
 * 请考虑一种方法，让农夫可以安全地安排这些东西和他自己过河。
 * <p/>
 */
public class RiverCrossingPuzzle {

    // 我们定义一个长度为 4 的字符串来表示对岸的状态其中，0 位表示农夫，1 位置表示狼，2 位置表示羊，3 位置表示菜
    // 求解的就是从 0000 这个状态到 1111 这个状态的最短路径
    private String initState = "0000";
    private String finalState = "1111";
    private String[] deadends = {"0111", "0110", "0011", "1000", "1001", "1100"};
    // visited key 表示该状态是否被遍历过，value key 的上一状态
    private Map<String, String> visited;

    public RiverCrossingPuzzle() {
        visited = new HashMap<>();
        HashSet<String> deadset = new HashSet<>();
        for (String deadend : deadends)
            deadset.add(deadend);

        Queue<String> q = new LinkedList<>();
        q.offer(initState);
        visited.put(initState, initState);

        while (!q.isEmpty()) {
            String cur = q.poll();
            List<String> nexts = getNexts(cur);
            for (String next : nexts) {
                if (!visited.containsKey(next) && !deadset.contains(next)) {
                    q.offer(next);
                    visited.put(next, cur);
                    if (next.equals(finalState))
                        return;
                }
            }
        }
    }

    private List<String> getNexts(String cur) {
        List<String> res = new ArrayList<>();
        char[] chars = cur.toCharArray();

        // 说明农夫在岸的左边，农夫可以带一个为 0 的其他东西过河,也可以自己过河
        if (chars[0] == '0') {
            chars[0] = '1';
            res.add(new String(chars));
            chars[0] = '0';
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == '0') {
                    chars[i] = '1';
                    chars[0] = '1';
                    res.add(new String(chars));
                    chars[0] = '0';
                    chars[i] = '0';
                }
            }
        } else {
            // 说明农夫在岸的右边，农夫可以带一个为 1 的其他东西过河,或者是自己过河
            chars[0] = '0';
            res.add(new String(chars));
            chars[0] = '1';
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == '1') {
                    chars[i] = '0';
                    chars[0] = '0';
                    res.add(new String(chars));
                    chars[0] = '1';
                    chars[i] = '1';
                }
            }
        }
        return res;
    }

    public Iterable<String> result() {
        List<String> res = new ArrayList<>();
        String cur = finalState;
        while (!cur.equals(initState)) {
            res.add(cur);
            cur = visited.get(cur);
        }
        res.add(initState);
        Collections.reverse(res);
        return res;
    }
}
