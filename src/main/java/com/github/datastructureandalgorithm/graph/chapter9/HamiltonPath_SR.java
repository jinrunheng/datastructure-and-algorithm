package com.github.datastructureandalgorithm.graph.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 基于状态压缩的哈密尔顿路径算法
 */
public class HamiltonPath_SR {
    private Graph G;
    private int s;
    private int[] pre;
    private int end;
    private int left;

    public HamiltonPath_SR(Graph G, int s) {
        this.G = G;
        this.s = s;
        int visited = 0;
        pre = new int[G.V()];
        end = -1;
        this.left = G.V();

        dfs(visited, s, s);
    }

    private boolean dfs(int visited, int v, int parent) {
        // visited[v] = true;
        visited += (1 << v);
        pre[v] = parent;
        left--;

        if (left == 0) {
            end = v;
            return true;
        }

        for (int w : G.adj(v)) {
            if ((visited & (1 << w)) == 0/*!visited[w]*/) {
                if (dfs(visited, w, v)) return true;
            }
        }

        // visited[v] = false;
        visited -= (1 << v);
        left++;
        return false;
    }

    /**
     * 返回哈密尔顿路径
     *
     * @return
     */
    public List<Integer> result() {
        List<Integer> res = new ArrayList<>();
        if (end == -1) return res;

        int cur = end;
        while (cur != s) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);
        Collections.reverse(res);
        return res;
    }
}
