package com.github.datastructureandalgorithm.graph.chapter4;

/**
 * 二分图检测
 */
public class BipartitionDetection {

    private Graph G;
    private boolean[] visited;
    private int[] colors; // 存储 0,1; 0,1 分别代表两种不同的颜色
    private boolean isBipartite = true;

    public BipartitionDetection(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        colors = new int[G.V()];

        for (int i = 0; i < colors.length; i++)
            colors[i] = -1;
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                if (!dfs(v, 0)) {
                    isBipartite = false;
                    break;
                }
            }
        }
    }

    /**
     * 对图进行 dfs 遍历，将 v 这个顶点染成 color 这个颜色,返回结果为该图是否是一个二分图
     *
     * @param v
     * @param color
     */
    private boolean dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;

        for (int w : G.adj(v)) {
            if (!visited[w]) {
                // color 为 0 传入的值就是 1，color 为 1 传入的值就是 0)
                if (!dfs(w, 1 - color)) {
                    return false;
                }
            } else if (colors[w] == colors[v]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检测是否为二分图
     *
     * @return
     */
    public boolean isBipartite() {
        return isBipartite;
    }
}
