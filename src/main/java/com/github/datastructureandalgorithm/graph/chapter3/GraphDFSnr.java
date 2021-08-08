package com.github.datastructureandalgorithm.graph.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归方式实现图的深度优先遍历
 */
public class GraphDFSnr {
    private List<Integer> pre = new ArrayList<>();

    private Graph G;
    private boolean[] visited;

    public GraphDFSnr(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v);
    }

    /**
     * 非递归方式对图进行深度优先遍历
     *
     * @param v
     */
    private void dfs(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            pre.add(cur);
            for (int w : G.adj(cur)) {
                if (!visited[w]) {
                    stack.push(w);
                    visited[w] = true;
                }
            }
        }
    }

    /**
     * 返回图的深度优先遍历的前序遍历的结果集
     *
     * @return
     */
    public Iterable<Integer> pre() {
        return pre;
    }
}
