package com.github.datastructureandalgorithm.graph.chapter3;

import java.util.ArrayList;
import java.util.List;

public class GraphDFS {

    private List<Integer> order = new ArrayList<>();
    private Graph G;
    private boolean[] visited;

    public GraphDFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v);
    }

    /**
     * 对图进行深度优先遍历
     *
     * @param v
     */
    private void dfs(int v) {
        visited[v] = true;
        order.add(v);
        for (int w : G.adj(v)) {
            if (!visited[w])
                dfs(w);
        }
    }

    /**
     * 返回图的深度优先遍历的结果集
     *
     * @return
     */
    public Iterable<Integer> order() {
        return order;
    }
}
