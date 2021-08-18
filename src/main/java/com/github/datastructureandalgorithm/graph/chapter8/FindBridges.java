package com.github.datastructureandalgorithm.graph.chapter8;

import java.util.ArrayList;
import java.util.List;

public class FindBridges {

    private Graph G;
    private boolean[] visited;

    private int[] ord;
    private int[] low;
    private int cnt;
    private List<Edge> res;

    public FindBridges(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        ord = new int[G.V()];
        low = new int[G.V()];
        res = new ArrayList<>();

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

        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w, v);
                low[v] = Math.min(low[w], low[v]);
                if (low[w] > ord[v])
                    // v-w is a bridge
                    res.add(new Edge(v, w));

            } else if (w != parent) {
                low[v] = Math.min(low[w], low[v]);
            }
        }
    }

    public List<Edge> result() {
        return res;
    }
}
