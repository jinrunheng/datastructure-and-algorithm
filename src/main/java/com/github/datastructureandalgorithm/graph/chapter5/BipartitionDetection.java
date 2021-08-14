package com.github.datastructureandalgorithm.graph.chapter5;

import java.util.LinkedList;
import java.util.Queue;

public class BipartitionDetection {
    private Graph G;
    private boolean[] visited;
    private int[] colors; // 存储 0,1; 0,1 分别代表两种不同的颜色
    private boolean isBipartite = true;

    public BipartitionDetection(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        colors = new int[G.V()];
        for (int i = 0; i < colors.length; i++)
            colors[i] = -1;
        for (int v = 0; v < G.V(); v++)
            if (!visited[v]) {
                if (bfs(v, 0)) {
                    isBipartite = false;
                    break;
                }
            }

    }

    private boolean bfs(int s, int color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;
        colors[s] = color;

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int w : G.adj(v))
                if (!visited[w]) {
                    q.offer(w);
                    visited[w] = true;
                    colors[w] = 1 - color;
                } else if (colors[w] == colors[v])
                    return false;
        }
        return true;
    }

    /**
     * 检测图是否为二分图
     *
     * @return
     */
    public boolean isBipartite() {
        return isBipartite;
    }
}
