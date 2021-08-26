package com.github.datastructureandalgorithm.graph.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HamiltonLoop {

    private Graph G;
    private boolean[] visited;
    private int[] pre;
    private int end;

    public HamiltonLoop(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        end = -1;
        dfs(0, 0);
    }

    /**
     * 对图进行深度优先遍历
     *
     * @param v
     */
    private boolean dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;

        for (int w : G.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) return true;
            } else if (w == 0 && allVisited()) {
                end = v;
                return true;
            }
        }
        visited[v] = false;
        return false;
    }

    private boolean allVisited() {
        for (boolean b : visited)
            if (!b) return false;

        return true;
    }

    /**
     * 获取哈密尔顿回路
     *
     * @return
     */
    public List<Integer> result() {
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
