package com.github.datastructureandalgorithm.graph.chapter4;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleSourcePath {

    private Graph G;
    private int s;
    private boolean[] visited;
    private int[] pre;

    public SingleSourcePath(Graph G, int s) {
        G.validateVertex(s);

        this.G = G;
        this.s = s;
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
    private void dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        for (int w : G.adj(v)) {
            if (!visited[w])
                dfs(w, v);
        }
    }

    /**
     * 判断 从源顶点 s 到 顶点 t 是否是可达的
     *
     * @param t
     * @return
     */
    public boolean isConnectedTo(int t) {
        G.validateVertex(t);
        return visited[t];
    }

    /**
     * 从源顶点 s 到顶点 t 的路径
     *
     * @param t
     * @return
     */
    public Iterable<Integer> path(int t) {
        List<Integer> res = new ArrayList<>();
        G.validateVertex(t);
        if (!isConnectedTo(t))
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
