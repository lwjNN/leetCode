package com.leetcode.week;

import java.util.Arrays;

/**
 * @author LWJ
 * @date 2020/6/7 11:19
 */
public class Solution_5428 {
    public static int[] shuffle(int[] nums, int n) {
        if(nums.length <=2){
            return nums;
        }
        int[] temp = new int[n*2];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i%2==0){
                temp[i] = nums[index++];
            } else{
                temp[i] = nums[n+index-1];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,1,3,4,7};
        int[] shuffle = shuffle(arr, 3);
        System.out.println(Arrays.toString(shuffle));
    }
}
