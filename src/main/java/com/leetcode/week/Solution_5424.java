package com.leetcode.week;

/**
 * @author LWJ
 * @date 2020/5/31 10:36
 */
public class Solution_5424 {
    public static int maxProduct(int[] nums) {
        int max = 0;
        int index = 0;
        int sec = 0;
        int index1 = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(max<nums[i]){
                max = nums[i];
                index = i;
            }

        }
        int temp = nums[length-1];
        nums[length-1] = max;
        nums[index] = temp;

        for (int i = 0; i < length-1; i++) {
            if(sec<nums[i]){
                sec = nums[i];
                index1 = i;
            }

        }
        int temp1 = nums[length-2];
        nums[length-2] = sec;
        nums[index1] = temp1;
        return (nums[length-1]-1) * (nums[length-2]-1);
    }

    public static void main(String[] args) {
        int[] arr = {1,5,4,5};
        System.out.println(maxProduct(arr));
    }
}
