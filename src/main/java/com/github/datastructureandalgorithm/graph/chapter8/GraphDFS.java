package com.github.datastructureandalgorithm.graph.chapter8;

import java.util.ArrayList;
import java.util.List;

public class GraphDFS {
    private List<Integer> pre = new ArrayList<>();
    private List<Integer> post = new ArrayList<>();

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
        pre.add(v);
        for (int w : G.adj(v)) {
            if (!visited[w])
                dfs(w);
        }
        post.add(v);
    }

    /**
     * 返回图的深度优先遍历的前序遍历的结果集
     *
     * @return
     */
    public Iterable<Integer> pre() {
        return pre;
    }

    /**
     * 返回图的深度优先遍历的后序遍历的结果集
     *
     * @return
     */
    public Iterable<Integer> post() {
        return post;
    }
}
