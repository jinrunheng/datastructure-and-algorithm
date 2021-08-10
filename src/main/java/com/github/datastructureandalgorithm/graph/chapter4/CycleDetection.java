package com.github.datastructureandalgorithm.graph.chapter4;

/**
 * 检测图中是否有环
 */
public class CycleDetection {
    private Graph G;
    private boolean[] visited;
    private boolean hasCycle;

    public CycleDetection(Graph G) {

        this.G = G;

        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v, v);
    }

    /**
     * 对图进行深度优先遍历.
     * <p>
     * 传入参数的含义，v 为遍历到的顶点，parent 为  v 顶点是从哪一个顶点遍历而来的
     *
     * @param v
     */
    private void dfs(int v, int parent) {
        visited[v] = true;

        for (int w : G.adj(v)) {
            if (!visited[w])
                dfs(w, v);
            else if (w != parent)
                hasCycle = true;
        }
    }

    /**
     * 返回当前图中是否有环
     *
     * @return
     */
    public boolean hasCycle() {
        return hasCycle;
    }
}
