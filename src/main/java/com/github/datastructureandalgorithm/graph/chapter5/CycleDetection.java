package com.github.datastructureandalgorithm.graph.chapter5;

import java.util.LinkedList;
import java.util.Queue;

public class CycleDetection {
    private Graph G;
    private boolean[] visited;
    private int[] pre;
    private boolean hasCycle = false;

    public CycleDetection(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        for (int i = 0; i < pre.length; i++)
            pre[i] = -1;

        for (int v = 0; v < G.V(); v++)
            if (!visited[v]) {
                if (bfs(v)) {
                    hasCycle = true;
                    break;
                }
            }
    }

    private boolean bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;
        pre[s] = s;

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : G.adj(v))
                if (!visited[w]) {
                    q.offer(w);
                    visited[w] = true;
                    pre[w] = v;
                }
                // 如果 w 已经被访问过，并且 w 不是 v 的上一个顶点，说明我们找到了环
                else if (pre[v] != w) {
                    return true;
                }
        }
        return false;
    }

    /**
     * 返回当前图中是否有环
     *
     * @return
     */
    public boolean hasCycle() {
        return hasCycle;
    }
}
