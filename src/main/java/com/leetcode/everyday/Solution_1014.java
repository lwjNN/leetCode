package com.leetcode.everyday;

/**
 * @author LWJ
 * @date 2020/6/17 9:45
 */
public class Solution_1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0;
        int mx = A[0]+0;
        for (int i = 1; i < A.length; i++) {
            ans = Math.max(mx,mx+A[i]-i);
            mx = Math.max(mx,A[i]+i);
        }
        return ans;
    }
}
