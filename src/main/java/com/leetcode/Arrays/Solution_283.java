package com.leetcode.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_283 {

    public static void moveZeroes(int[] nums) {
        if(null==nums || nums.length <= 1){
            return ;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] =0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,13,0,3};
        moveZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
