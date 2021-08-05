package com.github.datastructureandalgorithm.graph.chapter2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Adjacent Matrix 临接矩阵表示图
 */
public class AdjMatrix {
    // 图有多少个顶点
    private int V;
    // 图有多少条边
    private int E;

    private int[][] adj;

    public AdjMatrix(String filename) {
        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            adj = new int[V][V];
            E = scanner.nextInt();
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                adj[a][b] = 1;
                adj[b][a] = 1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                sb.append(String.format("%d ", adj[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
