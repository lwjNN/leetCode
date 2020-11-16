package com.leetcode.week;

/**
 * @author lwj
 * @date 2020/11/8 10:27
 */
public class Solution_1108_1 {
    public int getMaximumGenerated(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 1; i < n-1; i++) {
            if (2 * i <= n) {
                arr[2 * i] = arr[i];
            }
            if (2 * i + 1 <= n){
                arr[2*i +1] = arr[i] + arr[i+1];
            }
        }
        return getMax(arr);
    }

    public int getMax(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution_1108_1 s = new Solution_1108_1();
        s.getMaximumGenerated(7);
    }
}
