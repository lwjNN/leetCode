package com.leetcode.week;

import java.util.Arrays;

/**
 * @author LWJ
 * @date 2020/7/5 10:33
 */
public class Solution_5453 {
    public static int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;
        for (int i = 0; i < left.length; i++) {
            max = Math.max(max,left[i]);
        }
        for (int i = 0; i < right.length; i++) {
            max = Math.max(max,n-right[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] left = {0,1,2,3,4,5};
        int[] right = {6};
        System.out.println(getLastMoment(6, left, right));
    }
}
