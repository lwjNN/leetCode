package com.leetcode.week;

import java.util.Arrays;

/**
 * @author lwj
 * @date 2020/8/30 10:21
 */
public class Solution_0830_2 {
    public int getMaxLen(int[] nums) {
        int fast = 1;
        int slow = 0;
        int length = nums.length;
        while (fast<length){
            int[] ints = Arrays.copyOfRange(nums, slow, fast);
            if(charge(ints)){
                fast++;
            }else {
                slow++;
            }
        }
        //TODO
        return 0;
    }

    public boolean charge(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                num++;
            }else if(nums[i] == 0){
                return false;
            }
        }
        if(num%2==0){
            return true;
        }
        return false;
    }
}
