package com.leetcode.week;

import java.util.Arrays;

/**
 * @author lwj
 * @date 2022/7/24 10:26
 */
public class Solution0724_02 {
    public int equalPairs(int[][] grid) {
        int[][] change = change(grid);
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            out:for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k < grid.length; k++) {
                    if (grid[i][j]!= change[k][j]){
                        continue ;
                    }
                    if (j == grid.length - 1){
                        ans++;
                    }
                }

            }
        }
        return ans;
    }

    public int[][] change(int[][] grid){
        int[][] ans = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                ans[i][j] = grid[j][i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution0724_02 s = new Solution0724_02();
        int change = s.equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}});

        System.out.println(change);
    }
}
