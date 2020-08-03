package com.leetcode.everyday.july;

/**
 * @author LWJ
 * @date 2020/7/17 18:13
 */
public class Solution_35 {
    public int searchInsert(int[] nums, int target) {
        if(target>nums[nums.length/2]){
            for (int i = nums.length/2; i < nums.length; i++) {
                if(target <= nums[i]){
                    return i;
                }
            }
        }else{
            for (int i = 0; i < nums.length/2; i++) {
                if(target <= nums[i]){
                    return i;
                }
            }
        }
        return nums.length;
    }
}
