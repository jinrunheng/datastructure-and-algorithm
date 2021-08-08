package com.github.datastructureandalgorithm.graph.chapter4;

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

    public int count() {
        for (int e : visited)
            System.out.print(e + " ");
        System.out.println();
        return ccCount;
    }
}
