package com.github.datastructureandalgorithm.graph.chapter5;

import java.util.*;

public class Path {
    private Graph G;
    private int s;
    private int t;
    private boolean[] visited;
    private int[] pre;

    public Path(Graph G, int s, int t) {
        this.G = G;
        this.s = s;
        this.t = t;

        visited = new boolean[G.V()];
        pre = new int[G.V()];
        for (int i = 0; i < pre.length; i++)
            pre[i] = -1;

        bfs(s);
    }

    /**
     * 图的广度优先遍历
     *
     * @param s
     */
    private boolean bfs(int s) {
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
                    if (w == t) return true;
                }
        }
        return false;
    }

    /**
     * 判断 从顶点 s 到 顶点 t 是否是可达的
     *
     * @return
     */
    public boolean isConnected() {
        return visited[t];
    }

    /**
     * 从顶点 s 到顶点 t 的路径
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
