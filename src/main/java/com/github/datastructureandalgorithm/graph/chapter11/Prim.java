package com.github.datastructureandalgorithm.graph.chapter11;

import java.util.ArrayList;
import java.util.List;

public class Prim {

    private WeightedGraph G;
    private List<WeightedEdge> minimumSpanningTree;

    public Prim(WeightedGraph G) {
        this.G = G;
        minimumSpanningTree = new ArrayList<>();

        CC cc = new CC(G);
        if (cc.count() > 1) return;

        // Prim
        // true 表示为蓝色的顶点 false 表示为黑色的顶点
        boolean[] visited = new boolean[G.V()];
        visited[0] = true;
        for (int i = 1; i < G.V(); i++) {

            WeightedEdge minEdge = new WeightedEdge(-1, -1, Integer.MAX_VALUE);

            for (int v = 0; v < G.V(); v++)
                if (visited[v])
                    for (int w : G.adj(v))
                        if (!visited[w] && G.getWeight(v, w) < minEdge.getWeight())
                            minEdge = new WeightedEdge(v, w, G.getWeight(v, w));

            minimumSpanningTree.add(minEdge);
            visited[minEdge.getV()] = true;
            visited[minEdge.getW()] = true;
        }
    }

    public List<WeightedEdge> result() {
        return minimumSpanningTree;
    }
}
