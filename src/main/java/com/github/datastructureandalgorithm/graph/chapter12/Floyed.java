package com.github.datastructureandalgorithm.graph.chapter12;

import java.util.Arrays;

public class Floyed {
    private WeightedGraph G;
    private int[][] dis;
    public boolean hasNegativeCycle = false;

    public Floyed(WeightedGraph G) {
        this.G = G;
        dis = new int[G.V()][G.V()];
        for (int i = 0; i < G.V(); i++)
            Arrays.fill(dis[i], Integer.MAX_VALUE);

        for (int v = 0; v < G.V(); v++) {
            dis[v][v] = 0;
            for (int w : G.adj(v))
                dis[v][w] = G.getWeight(v, w);
        }

        for (int t = 0; t < G.V(); t++)
            for (int v = 0; v < G.V(); v++)
                for (int w = 0; w < G.V(); w++)
                    if (dis[v][t] != Integer.MAX_VALUE
                            && dis[t][w] != Integer.MAX_VALUE
                            && dis[v][t] + dis[t][w] < dis[v][w])
                        dis[v][w] = dis[v][t] + dis[t][w];

        for (int v = 0; v < G.V(); v++)
            if (dis[v][v] < 0) hasNegativeCycle = true;
    }

    public boolean isConnected(int v, int w) {
        if (v < 0 || v >= G.V())
            throw new IllegalArgumentException("vertex" + v + "is invalid");
        if (w < 0 || w >= G.V())
            throw new IllegalArgumentException("vertex" + w + "is invalid");
        return dis[v][w] != Integer.MAX_VALUE;
    }

    public int dis(int v, int w) {
        if (v < 0 || v >= G.V())
            throw new IllegalArgumentException("vertex" + v + "is invalid");
        if (w < 0 || w >= G.V())
            throw new IllegalArgumentException("vertex" + w + "is invalid");
        return dis[v][w];
    }
}
