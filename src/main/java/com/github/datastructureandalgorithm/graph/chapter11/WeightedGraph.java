package com.github.datastructureandalgorithm.graph.chapter11;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 无向带权图
 */
public class WeightedGraph {
    // 图有多少个顶点
    private int V;
    // 图有多少条边
    private int E;

    // key 为 相邻的顶点，value 对应的为权
    private TreeMap<Integer, Integer>[] adj;

    public WeightedGraph(String filename) {
        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if (V < 0) throw new IllegalArgumentException("V must be non-negative");

            adj = new TreeMap[V];
            for (int i = 0; i < V; i++)
                adj[i] = new TreeMap<>();


            E = scanner.nextInt();
            if (E < 0) throw new IllegalArgumentException("E must be non-negative");

            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);
                int weight = scanner.nextInt();

                if (a == b) throw new IllegalArgumentException("Self Loop is detected");
                if (adj[a].containsKey(b)) throw new IllegalArgumentException("Parallel Edges are detected");

                adj[a].put(b, weight);
                adj[b].put(a, weight);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex" + v + "is invalid");
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v].containsKey(w);
    }

    /**
     * 返回和 v 顶点相邻的顶点
     *
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v].keySet();
    }

    /**
     * 获取顶点 v 和顶点 w 相连的边的权值
     *
     * @param v
     * @param w
     * @return
     */
    public int getWeight(int v, int w) {
        if (hasEdge(v, w))
            return adj[v].get(w);
        throw new IllegalArgumentException(String.format("No edge %d-%d !", v, w));
    }

    /**
     * 返回一个顶点的度（度的概念就是一个顶点有多少条邻边）
     *
     * @return
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int v = 0; v < V; v++) {
            sb.append(String.format("%d : ", v));

            for (Map.Entry<Integer, Integer> entries : adj[v].entrySet()) {
                sb.append(String.format("(%d：%d)", entries.getKey(), entries.getValue()));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

