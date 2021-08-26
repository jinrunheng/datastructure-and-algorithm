package com.github.datastructureandalgorithm.graph.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HamiltonPath {
    private Graph G;
    private int s;
    private boolean[] visited;
    private int[] pre;
    private int end;
    private int left;

    public HamiltonPath(Graph G, int s) {
        this.G = G;
        this.s = s;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        end = -1;
        this.left = G.V();

        dfs(s, s);
    }

    private boolean dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        left--;

        if (left == 0) {
            end = v;
            return true;
        }

        for (int w : G.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) return true;
            }
        }

        visited[v] = false;
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
