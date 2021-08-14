package com.github.datastructureandalgorithm.graph.chapter5;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CC {

    private int ccCount = 0;
    private Graph G;
    private int[] visited;

    public CC(Graph G) {
        this.G = G;
        visited = new int[G.V()];
        for (int i = 0; i < visited.length; i++)
            visited[i] = -1;

        for (int v = 0; v < G.V(); v++)
            if (visited[v] == -1) {
                bfs(v, ccCount);
                ccCount++;
            }
    }

    /**
     * 对图进行广度优先遍历
     *
     * @param s
     * @param ccId
     */
    private void bfs(int s, int ccId) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = ccId;

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int w : G.adj(v))
                if (visited[w] == -1) {
                    q.offer(w);
                    visited[w] = ccId;
                }
        }
    }

    /**
     * 判断顶点 v 和顶点 w 是否在同一个联通分量中
     *
     * @param v
     * @param w
     * @return
     */
    public boolean isConnected(int v, int w) {
        G.validateVertex(v);
        G.validateVertex(w);
        return visited[v] == visited[w];
    }

    /**
     * 返回图的联通分量的顶点集合
     *
     * @return
     */
    public List<Integer>[] components() {
        List<Integer>[] res = new ArrayList[ccCount];
        for (int i = 0; i < ccCount; i++)
            res[i] = new ArrayList<>();

        for (int v = 0; v < G.V(); v++)
            res[visited[v]].add(v);

        return res;
    }
}
