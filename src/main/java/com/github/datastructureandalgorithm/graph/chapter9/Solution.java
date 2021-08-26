package com.github.datastructureandalgorithm.graph.chapter9;

/**
 * LeetCode 980.不同路径 III：https://leetcode-cn.com/problems/unique-paths-iii/
 */
class Solution {
    private int[][] grid;
    private int r, c;
    private boolean[][] visited;
    private int left;
    private int start;
    private int end;
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.r = grid.length;
        this.c = grid[0].length;
        this.visited = new boolean[r][c];
        this.left = r * c;

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

        return dfs(start);
    }

    int dfs(int s) {
        int x = s / c;
        int y = s % c;

        visited[x][y] = true;
        left--;

        if (s == end && left == 0) {
            // 回溯
            visited[x][y] = false;
            left++;
            return 1;
        }

        int res = 0;
        for (int d = 0; d < 4; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];

            if (isValid(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] != -1) {
                int next = nextX * c + nextY;
                res += dfs(next);
            }
        }

        // 回溯
        visited[x][y] = false;
        left++;

        return res;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}