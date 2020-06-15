package com.leetcode.week;

/**
 * @author LWJ
 * @date 2020/6/14 10:27
 */
public class Solution_5436 {
    public static int[] runningSum(int[] nums) {
        int res = 0;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
            arr[i] = res;
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
