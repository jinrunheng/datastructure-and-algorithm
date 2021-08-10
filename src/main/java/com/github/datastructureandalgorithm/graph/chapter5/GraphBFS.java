package com.github.datastructureandalgorithm.graph.chapter5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    private Graph G;
    private boolean[] visited;
    private ArrayList<Integer> order = new ArrayList<>();

    public GraphBFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                bfs(v);
    }

    /**
     * 图的广度优先遍历
     *
     * @param s
     */
    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            order.add(v);
            for (int w : G.adj(v))
                if (!visited[w]) {
                    queue.offer(w);
                    visited[w] = true;
                }
        }
    }

    /**
     * 返回图的广度优先遍历的结果
     *
     * @return
     */
    public Iterable<Integer> order() {
        return order;
    }

}
