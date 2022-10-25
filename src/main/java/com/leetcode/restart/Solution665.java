package com.leetcode.restart;

/**
 *
 * @author lwj
 * @date 2022/7/12 21:45
 */
public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        int index = 0;
        int min = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]){
                index++;
            }
        }
        return index < 2;
    }
}
