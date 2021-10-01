package com.github.datastructureandalgorithm.graph.chapter12;

import java.util.Arrays;

public class BellmanFord {
    private WeightedGraph G;
    private int s;
    private int[] dis;
    private boolean hasNegativeCycle = false;

    public BellmanFord(WeightedGraph G, int s) {
        this.G = G;
        if (s < 0 || s >= G.V())
            throw new IllegalArgumentException("vertex" + s + "is invalid");
        this.s = s;
        dis = new int[G.V()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0;

        for (int pass = 1; pass < G.V(); pass++) {

            for (int v = 0; v < G.V(); v++)
                for (int w : G.adj(v))
                    if (dis[v] != Integer.MAX_VALUE && dis[v] + G.getWeight(v, w) < dis[w])
                        dis[w] = dis[v] + G.getWeight(v, w);
        }

        // 再进行一次放松(松弛)操作
        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                if (dis[v] != Integer.MAX_VALUE && dis[v] + G.getWeight(v, w) < dis[w])
                    hasNegativeCycle = true;

    }

    public boolean isConnected(int v) {
        if (v < 0 || v >= G.V())
            throw new IllegalArgumentException("vertex" + v + "is invalid");
        return dis[v] != Integer.MAX_VALUE;
    }

    public int dis(int v) {
        if (v < 0 || v >= G.V())
            throw new IllegalArgumentException("vertex" + v + "is invalid");
        if (hasNegativeCycle) throw new RuntimeException("Exist negative cycle");
        return dis[v];
    }

}
