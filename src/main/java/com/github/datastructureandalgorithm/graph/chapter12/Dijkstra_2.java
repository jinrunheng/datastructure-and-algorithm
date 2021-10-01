package com.github.datastructureandalgorithm.graph.chapter12;

import com.sun.tools.javac.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra_2 {
    private WeightedGraph G;
    private int s;
    private int[] dis;
    private boolean[] visited;

    public Dijkstra_2(WeightedGraph G, int s) {
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

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.snd));
        pq.offer(new Pair<>(s, 0));

        while (!pq.isEmpty()) {
            int cur = pq.poll().fst;
            if (visited[cur]) continue;
            visited[cur] = true;
            for (int w : G.adj(cur))
                if (!visited[w] && dis[cur] + G.getWeight(cur, w) < dis[w]) {
                    dis[w] = dis[cur] + G.getWeight(cur, w);
                    pq.offer(new Pair<>(w, dis[w]));
                }
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
