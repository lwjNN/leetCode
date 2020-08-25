package com.leetcode.dfs_bfs;

/**
 * @author lwj
 * @date 2020/8/12 10:25
 */
public class Solution_200 {
    int n, m;

    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        int islandNumber = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ++islandNumber;
                    dfs(grid, i, j);
                }
            }

        }
        return islandNumber;
    }

    //将是小岛的进行深度优先搜索。把与之相邻的小岛都标记
    public void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
