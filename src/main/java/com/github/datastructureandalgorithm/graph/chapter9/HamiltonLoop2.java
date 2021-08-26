package com.github.datastructureandalgorithm.graph.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HamiltonLoop2 {
    private Graph G;
    private boolean[] visited;
    private int[] pre;
    private int end;
    private int left;

    public HamiltonLoop2(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        end = -1;
        left = G.V();
        dfs(0, 0);
    }

    /**
     * 对图进行深度优先遍历
     *
     * @param v
     * @param parent
     * @return
     */
    private boolean dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        left--;

        for (int w : G.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) return true;
            } else if (w == 0 && left == 0) {
                end = v;
                return true;
            }
        }
        visited[v] = false;
        left++;
        return false;
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
