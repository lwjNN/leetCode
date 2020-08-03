package com.leetcode.week;

/**
 * @author LWJ
 * @date 2020/7/12 10:34
 */
public class Solution_5460 {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
