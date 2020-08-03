package com.leetcode.week;

/**
 * @author LWJ
 * @date 2020/6/28 11:24
 */
public class Solution_5449 {
    public static boolean canArrange(int[] arr, int k) {
        int[] modArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            modArr[i] = arr[i]%k;
        }
        int res = 0;
        for (int i = 0; i < modArr.length; i++) {
            res += modArr[i];
        }
        return res%k == 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(canArrange(arr, 10));
    }
}
