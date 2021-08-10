package com.github.datastructureandalgorithm.graph.chapter4;

/**
 * 所有点对路径问题，从图中任意一个顶点 v 到另一个顶点 w 是否有可达的路径
 */
public class AllPairsPath {

    private Graph G;
    private SingleSourcePath[] paths;

    public AllPairsPath(Graph G) {
        this.G = G;
        paths = new SingleSourcePath[G.V()];
        for (int v = 0; v < G.V(); v++)
            paths[v] = new SingleSourcePath(G, v);
    }

    /**
     * 从顶点 s 到顶点 t 是否存在路径
     *
     * @return
     */
    public boolean isConnectedTo(int s, int t) {
        G.validateVertex(s);
        G.validateVertex(t);

        return paths[s].isConnectedTo(t);
    }

    /**
     * 返回从顶点 s 到顶点 t 的路径
     *
     * @param s
     * @param t
     * @return
     */
    public Iterable<Integer> path(int s, int t) {
        G.validateVertex(s);
        G.validateVertex(t);

        return paths[s].path(t);
    }
}
