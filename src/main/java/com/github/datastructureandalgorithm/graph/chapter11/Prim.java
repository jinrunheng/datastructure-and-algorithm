package com.github.datastructureandalgorithm.graph.chapter11;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prim {

    private WeightedGraph G;
    private List<WeightedEdge> minimumSpanningTree;

    public Prim(WeightedGraph G) {
        this.G = G;
        minimumSpanningTree = new ArrayList<>();

        // 判断该图的联通分量是否为 1，如果大于 1 说明不存在最小生成树
        CC cc = new CC(G);
        if (cc.count() > 1) return;

        // Prim
        // true 表示为蓝色的顶点 false 表示为黑色的顶点
        boolean[] visited = new boolean[G.V()];
        visited[0] = true;
        Queue<WeightedEdge> pq = new PriorityQueue<>(); // 最小堆
        for (int w : G.adj(0))
            pq.offer(new WeightedEdge(0, w, G.getWeight(0, w)));

        while (!pq.isEmpty()) {
            WeightedEdge minEdge = pq.remove();
            if (visited[minEdge.getV()] && visited[minEdge.getW()])
                continue;

            minimumSpanningTree.add(minEdge);

            int p = visited[minEdge.getV()] ? minEdge.getW() : minEdge.getV();
            visited[p] = true;
            for (int w : G.adj(p))
                if (!visited[w])
                    pq.offer(new WeightedEdge(w, p, G.getWeight(w, p)));
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
