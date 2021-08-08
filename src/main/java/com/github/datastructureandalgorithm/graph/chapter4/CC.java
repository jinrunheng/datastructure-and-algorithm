package com.github.datastructureandalgorithm.graph.chapter4;

public class CC {

    private int ccCount = 0; // 联通分量的个数
    private Graph G;
    private boolean[] visited;

    public CC(Graph G) {
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

    public int count() {
        return ccCount;
    }
}
