package com.github.datastructureandalgorithm.graph.chapter7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 773. 滑动谜题
 *
 * https://leetcode-cn.com/problems/sliding-puzzle/
 */
class Solution {
    private boolean[] visited;
    private int[] pre;
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int slidingPuzzle(int[][] board) {
        visited = new boolean[550000];
        pre = new int[550000];

        Queue<Integer> q = new LinkedList<>();
        int initState = board2num(board);
        if (initState == 123450) return 0;

        q.offer(initState);
        visited[initState] = true;
        pre[initState] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> nexts = getNexts(cur);
            for (int next : nexts) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    pre[next] = pre[cur] + 1;
                    if (next == 123450)
                        return pre[next];
                }
            }
        }
        return -1;
    }

    private List<Integer> getNexts(int cur) {
        List<Integer> res = new ArrayList<>();
        int[][] board = num2board(cur);
        int zeroX = -1;
        int zeroY = -1;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == 0) {
                    zeroX = i;
                    zeroY = j;
                }

        for (int d = 0; d < 4; d++) {
            int nextX = zeroX + dirs[d][0];
            int nextY = zeroY + dirs[d][1];
            if (isValid(nextX, nextY)) {
                swap(board, zeroX, zeroY, nextX, nextY);
                res.add(board2num(board));
                swap(board, zeroX, zeroY, nextX, nextY);
            }
        }
        return res;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < 2 && y >= 0 && y < 3;
    }

    private void swap(int[][] board, int x1, int y1, int x2, int y2) {
        int tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    private int[][] num2board(int num) {
        int[][] res = new int[2][3];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                if (i == 0) {
                    res[i][j] = getDigit(num, i * 2 + j);
                } else {
                    res[i][j] = getDigit(num, i * 2 + j + 1);
                }

        return res;
    }

    private int getDigit(int num, int index) {
        String s = String.valueOf(num);

        if (num > 100000) {
            return s.charAt(index) - '0';
        } else {
            if (index == 0)
                return 0;
            return s.charAt(index - 1) - '0';
        }
    }

    private int board2num(int[][] board) {
        return board[0][0] * 100000
                + board[0][1] * 10000
                + board[0][2] * 1000
                + board[1][0] * 100
                + board[1][1] * 10
                + board[1][2] * 1;
    }
}