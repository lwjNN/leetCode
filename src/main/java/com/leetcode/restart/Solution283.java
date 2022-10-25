package com.leetcode.restart;

import java.util.Arrays;

/**
 * @author lwj
 * @date 2022/7/19 20:07
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2){
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }


    public static void main(String[] args) {
        Solution283 s = new Solution283();
        s.moveZeroes(new int[]{0,1,0,3,12});
    }
}
