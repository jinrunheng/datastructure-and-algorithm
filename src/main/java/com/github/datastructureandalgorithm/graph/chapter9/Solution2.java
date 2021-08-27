package com.github.datastructureandalgorithm.graph.chapter9;

import java.util.Arrays;

/**
 * LeetCode 980.不同路径 III：https://leetcode-cn.com/problems/unique-paths-iii/
 * <p>
 * 添加了对 visited 状态压缩的优化
 * 添加了记忆化搜索
 */
public class Solution2 {
    private int[][] grid;
    private int r, c;
    private int left;
    private int start;
    private int end;
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int[][] memory;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.r = grid.length;
        this.c = grid[0].length;
        this.left = r * c;
        int visited = 0;

        this.memory = new int[1 << r * c][r * c];

        for (int i = 0; i < memory.length; i++)
            Arrays.fill(memory[i], -1);

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (grid[i][j] == 1) {
                    start = i * c + j;
                    grid[i][j] = 0;
                } else if (grid[i][j] == 2) {
                    end = i * c + j;
                    grid[i][j] = 0;
                } else if (grid[i][j] == -1) {
                    left--;
                }

        return dfs(visited, start);
    }

    int dfs(int visited, int s) {
        // 说明该状态已经被记录过
        if (memory[visited][s] != -1)
            return memory[visited][s];

        visited += (1 << s);
        left--;

        if (s == end && left == 0) {
            // 回溯
            visited -= (1 << s);
            left++;
            memory[visited][s] = 1;
            return 1;
        }

        int res = 0;
        int x = s / c;
        int y = s % c;
        for (int d = 0; d < 4; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            int next = nextX * c + nextY;
            if (isValid(nextX, nextY) && (visited & (1 << next)) == 0 && grid[nextX][nextY] != -1) {
                res += dfs(visited, next);
            }
        }

        // 回溯
        visited -= (1 << s);
        left++;
        memory[visited][s] = res;
        return res;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}
