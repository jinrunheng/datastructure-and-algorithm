package com.github.datastructureandalgorithm.graph.chapter11;


import java.util.HashMap;
import java.util.Map;

public class UnionFind {

    private Map<Integer, Integer> map;
    private Map<Integer, Integer> size;

    public UnionFind(int n) {
        map = new HashMap<>();
        size = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, i);
            size.put(i, 1);
        }
    }

    // 找到节点的头节点
    public int find(int i) {
        int root = map.get(i);
        if (i != root) {
            root = find(root);
        }
        map.put(i, root);
        return root;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            int pSize = size.get(pRoot);
            int qSize = size.get(qRoot);

            if (pSize < qSize) {
                map.put(pRoot, qRoot);
                size.put(qRoot, pSize + qSize);
            } else {
                map.put(qRoot, pRoot);
                size.put(pRoot, qSize + pSize);
            }
        }
    }

    public boolean isSameSet(int p, int q) {
        return find(p) == find(q);
    }
}
