package com.github.datastructureandalgorithm.graph.chapter12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BellmanFord_2 {
    private WeightedGraph G;
    private int s;
    private int[] dis;
    // 记录每个顶点的前一个顶点
    private int[] pre;
    public boolean hasNegativeCycle = false;

    public BellmanFord_2(WeightedGraph G, int s) {
        this.G = G;
        if (s < 0 || s >= G.V())
            throw new IllegalArgumentException("vertex" + s + "is invalid");
        this.s = s;
        dis = new int[G.V()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0;

        pre = new int[G.V()];
        Arrays.fill(pre, -1);

        for (int pass = 1; pass < G.V(); pass++) {

            for (int v = 0; v < G.V(); v++)
                for (int w : G.adj(v))
                    if (dis[v] != Integer.MAX_VALUE && dis[v] + G.getWeight(v, w) < dis[w]) {
                        dis[w] = dis[v] + G.getWeight(v, w);
                        pre[w] = v;
                    }
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

    public Iterable<Integer> path(int t) {
        List<Integer> path = new ArrayList<>();
        if (!isConnected(t)) return path;

        int cur = t;
        while (cur != s) {
            path.add(cur);
            cur = pre[cur];
        }
        path.add(s);
        Collections.reverse(path);
        return path;
    }
}
