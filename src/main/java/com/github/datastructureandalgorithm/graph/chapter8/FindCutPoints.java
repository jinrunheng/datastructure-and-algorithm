package com.github.datastructureandalgorithm.graph.chapter8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindCutPoints {
    private Graph G;
    private boolean[] visited;

    private int[] ord;
    private int[] low;
    private int cnt;
    private HashSet<Integer> res;

    public FindCutPoints(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        ord = new int[G.V()];
        low = new int[G.V()];
        res = new HashSet<>();

        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v, v);
    }

    /**
     * 对图进行深度优先遍历
     *
     * @param v
     */
    private void dfs(int v, int parent) {
        visited[v] = true;
        ord[v] = cnt;
        low[v] = ord[v];
        cnt++;

        int child = 0;
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w, v);
                low[v] = Math.min(low[w], low[v]);
                if (v != parent && low[w] >= ord[v])
                    res.add(v);

                child++;
                if (v == parent && child > 1)
                    res.add(v);

            } else if (w != parent) {
                low[v] = Math.min(low[w], low[v]);
            }
        }
    }

    public HashSet<Integer> result() {
        return res;
    }
}
