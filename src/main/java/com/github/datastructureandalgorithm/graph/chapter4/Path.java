package com.github.datastructureandalgorithm.graph.chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Path {
    private Graph G;
    private int s;
    private int t;
    private boolean[] visited;
    private int[] pre;

    public Path(Graph G, int s, int t) {
        G.validateVertex(s);
        G.validateVertex(t);

        this.G = G;
        this.s = s;
        this.t = t;

        visited = new boolean[G.V()];
        pre = new int[G.V()];

        for (int i = 0; i < pre.length; i++)
            pre[i] = -1;

        dfs(s, s);
    }

    /**
     * 对图进行深度优先遍历.
     * <p>
     * 传入参数的含义，v 为遍历到的顶点，parent 为  v 顶点是从哪一个顶点遍历而来的
     *
     * @param v
     */
    private boolean dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;

        if (v == t) return true;

        for (int w : G.adj(v)) {
            if (!visited[w])
                if (dfs(w, v)) return true;
        }

        return false;
    }

    /**
     * 判断 从源顶点 s 到 顶点 t 是否是可达的
     *
     * @return
     */
    public boolean isConnected() {
        return visited[t];
    }

    /**
     * 从源顶点 s 到顶点 t 的路径
     *
     * @return
     */
    public Iterable<Integer> path() {
        List<Integer> res = new ArrayList<>();
        G.validateVertex(t);
        if (!isConnected())
            return res;

        int cur = t;
        while (cur != s) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);
        Collections.reverse(res);
        return res;
    }
}
