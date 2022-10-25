package com.leetcode.restart;

import java.util.Arrays;

/**
 * @author lwj
 * @date 2022/7/28 10:52
 */
public class Solution189 {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[(i+k)%n] = nums[i];
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
    }

    public static void main(String[] args) {
        rotate(new int[]{1,2,3},4);
    }
}
