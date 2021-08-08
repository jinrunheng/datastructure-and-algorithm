package com.github.datastructureandalgorithm.graph.chapter4;

import java.util.ArrayList;
import java.util.List;

public class CC {

    private int ccCount = 0; // 联通分量的个数
    private Graph G;
    private int[] visited;

    public CC(Graph G) {
        this.G = G;
        visited = new int[G.V()];
        for (int i = 0; i < visited.length; i++)
            visited[i] = -1;

        for (int v = 0; v < G.V(); v++) {
            if (visited[v] == -1) {
                dfs(v, ccCount);
                ccCount++;
            }
        }
    }

    /**
     * 对图进行深度优先遍历
     *
     * @param v
     */
    private void dfs(int v, int ccId) {
        visited[v] = ccId;
        for (int w : G.adj(v)) {
            if (visited[w] == -1)
                dfs(w, ccId);
        }
    }

    /**
     * 返回联通分量的个数
     *
     * @return
     */
    public int count() {
        return ccCount;
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
