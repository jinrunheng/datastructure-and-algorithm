package com.github.datastructureandalgorithm.graph.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HamiltonLoop_SR2 {
    private Graph G;
    private int[] pre;
    private int end;

    public HamiltonLoop_SR2(Graph G) {
        this.G = G;
        int visited = 0;
        pre = new int[G.V()];
        end = -1;
        dfs(visited, 0, 0, G.V());
    }

    /**
     * 对图进行深度优先遍历
     *
     * @param v
     * @param parent
     * @param left   表示还有多少个点没有遍历
     * @return
     */
    private boolean dfs(int visited, int v, int parent, int left) {
        // visited[v] = true
        visited += (1 << v);
        pre[v] = parent;
        left--;

        if (left == 0 && G.hasEdge(0, v)) {
            end = v;
            return true;
        }

        for (int w : G.adj(v))
            if ((visited & (1 << w)/*!visited[w]*/) == 0) {
                if (dfs(visited, w, v, left)) return true;
            }

        // visited[v] = false
        visited -= (1 << v);
        return false;
    }

    /**
     * 获取哈密尔顿回路
     *
     * @return
     */
    public List<Integer> result() {
        List<Integer> res = new ArrayList<>();
        if (end == -1) return res;
        int cur = end;
        while (cur != 0) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(0);
        Collections.reverse(res);
        return res;
    }
}
