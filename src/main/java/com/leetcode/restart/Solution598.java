package com.leetcode.restart;

/**
 * @author lwj
 * @date 2022/7/26 20:02
 */
public class Solution598 {
    public int maxCount(int m, int n, int[][] ops) {
        int mina = m;
        int minb = n;
        for (int[] op : ops) {
            mina = Math.min(mina, op[0]);
            minb = Math.min(minb, op[1]);
        }
        return mina * minb;
    }
}
