package com.github.datastructureandalgorithm.graph.chapter4;

public class GraphIsTree {
    private Graph G;
    private int ccCount = 0; // 联通分量的个数
    private boolean[] visited;
    private boolean hasCycle;

    public GraphIsTree(Graph G) {

        this.G = G;

        visited = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++)
            if (!visited[v]) {
                if (dfs(v, v)) {
                    hasCycle = true;
                    break;
                }
                ccCount++;
                if (ccCount > 1) {
                    break;
                }
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
     * 返回图是否是一棵树
     *
     * @return
     */
    public boolean isTree() {
        return ccCount == 1 && !hasCycle;
    }
}
