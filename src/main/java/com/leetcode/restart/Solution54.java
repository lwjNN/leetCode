package com.leetcode.restart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwj
 * @date 2022/8/3 19:49
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int count = (Math.min(m, n) + 1) / 2;
        while (i < count) {
            for (int j = i; j < n - i; j++) {
                ans.add(matrix[i][j]);
            }

            for (int j = i + 1; j < m - i; j++) {
                ans.add(matrix[j][n - i - 1]);
            }

            for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i != i); j--) {
                ans.add(matrix[m - 1 - i][j]);
            }
            for (int j = (m - 1) - (i + 1); j >= i + 1 && (n - 1 - i) != i; j--) {
                ans.add(matrix[j][i]);
            }
            i++;
        }
        return ans;
    }
}
