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
                if (dfs(v, v)) {
                    hasCycle = true;
                    break;
                }
    }

    /**
     * 从顶点 v 开始，判断图中是否有环
     * <p>
     * 传入参数的含义，v 为遍历到的顶点，parent 为  v 顶点是从哪一个顶点遍历而来的
     *
     * @param v
     */
    private boolean dfs(int v, int parent) {
        visited[v] = true;

        for (int w : G.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) {
                    return true;
                }
            } else if (w != parent)
                return true;
        }
        return false;
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
