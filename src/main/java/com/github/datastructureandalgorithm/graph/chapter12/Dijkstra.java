package com.github.datastructureandalgorithm.graph.chapter12;

import java.util.Arrays;

public class Dijkstra {

    private WeightedGraph G;
    private int s;
    private int[] dis;
    private boolean[] visited;

    public Dijkstra(WeightedGraph G, int s) {
        this.G = G;
        if (s < 0 || s >= G.V())
            throw new IllegalArgumentException("vertex" + s + "is invalid");
        this.s = s;
        dis = new int[G.V()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0;

        visited = new boolean[G.V()];

        // Dijkstra 算法的流程
        // 1. 找到当前没有访问的最短路节点
        // 2. 确认这个节点的最短路就是当前大小
        // 3. 根据这个节点的最短路大小，寻找这个节点相邻的节点并更新其他节点的路径长度
        while (true) {
            int curdis = Integer.MAX_VALUE;
            int cur = -1;

            for (int v = 0; v < G.V(); v++)
                if (!visited[v] && dis[v] < curdis) {
                    curdis = dis[v];
                    cur = v;
                }

            if (cur == -1) break;

            visited[cur] = true;
            for (int w : G.adj(cur))
                if (!visited[w] && dis[cur] + G.getWeight(cur, w) < dis[w])
                    dis[w] = dis[cur] + G.getWeight(cur, w);
        }
    }


    public boolean isConnected(int v) {
        if (v < 0 || v >= G.V())
            throw new IllegalArgumentException("vertex" + s + "is invalid");

        return visited[v];
    }

    public int dis(int v) {
        if (v < 0 || v >= G.V())
            throw new IllegalArgumentException("vertex" + s + "is invalid");
        return dis[v];
    }

}
