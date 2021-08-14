package com.github.datastructureandalgorithm.graph.chapter5;

import java.util.*;

public class SingleSourcePath {
    private Graph G;
    private int s;
    private boolean[] visited;
    private int[] pre;

    public SingleSourcePath(Graph G, int s) {
        this.G = G;
        this.s = s;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        for (int i = 0; i < pre.length; i++)
            pre[i] = -1;

        bfs(s);
    }

    /**
     * 图的广度优先遍历
     */
    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;
        pre[s] = s;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int w : G.adj(v))
                if (!visited[w]) {
                    queue.offer(w);
                    visited[w] = true;
                    pre[w] = v;
                }
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
        G.validateVertex(t);
        List<Integer> res = new ArrayList<>();
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
