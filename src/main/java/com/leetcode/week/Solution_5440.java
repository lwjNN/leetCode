package com.leetcode.week;

/**
 * @author LWJ
 * @date 2020/6/21 10:31
 */
public class Solution_5440 {
    public static int xorOperation(int n, int start) {
        int[] tmp = new int[n];
        int res = start;
        tmp[0] = start;
        for (int i = 1; i < n; i++) {
            tmp[i] = start + 2*i;
            res = res^tmp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(10, 5));
    }
}
