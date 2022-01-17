package com.github.datastructureandalgorithm.graph.chapter10;

public class EulerLoop {
    private Graph G;

    public EulerLoop(Graph G) {
        this.G = G;
    }

    /**
     * 判断是否存在欧拉回路
     *
     * @return
     */
    public boolean hasEulerLoop() {
        // 首先，G 必须是一个联通图
        CC cc = new CC(G);
        if (cc.count() > 1)
            return false;
        for (int v = 0; v < G.V(); v++)
            if (G.degree(v) % 2 == 1) return false;

        return true;
    }


}
