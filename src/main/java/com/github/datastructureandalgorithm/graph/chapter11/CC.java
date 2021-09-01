package com.github.datastructureandalgorithm.graph.chapter11;

import com.github.datastructureandalgorithm.graph.chapter4.Graph;

import java.util.ArrayList;
import java.util.List;

public class CC {

    private WeightedGraph G;
    private boolean[] visited;
    private int ccCount = 0; // 初始化图的联通分量的个数

    public CC(WeightedGraph G) {
        this.G = G;
        visited = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                dfs(v);
                ccCount++;
            }
        }
    }

    /**
     * 对图进行深度优先遍历
     *
     * @param v
     */
    private void dfs(int v) {
        visited[v] = true;
        for (int w : G.adj(v)) {
            if (!visited[w])
                dfs(w);
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

}