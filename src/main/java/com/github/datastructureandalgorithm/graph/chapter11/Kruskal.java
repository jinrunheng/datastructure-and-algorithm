package com.github.datastructureandalgorithm.graph.chapter11;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    private WeightedGraph G;
    private List<WeightedEdge> minimumSpanningTree;

    public Kruskal(WeightedGraph G) {
        this.G = G;
        minimumSpanningTree = new ArrayList<>();

        CC cc = new CC(G);
        if (cc.count() > 1) return;

        // Kruskal
        List<WeightedEdge> edges = new ArrayList<>();

        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                if (v < w)
                    edges.add(new WeightedEdge(v, w, G.getWeight(v, w)));

        Collections.sort(edges);
        UnionFind unionFind = new UnionFind(G.V());
        for (WeightedEdge edge : edges) {
            int v = edge.getV();
            int w = edge.getW();
            if (!unionFind.isSameSet(v, w)) {
                minimumSpanningTree.add(edge);
                unionFind.union(v, w);
            }
        }
    }

    /**
     * 返回最小生成树的结果集
     *
     * @return
     */
    public List<WeightedEdge> result() {
        return minimumSpanningTree;
    }

}
