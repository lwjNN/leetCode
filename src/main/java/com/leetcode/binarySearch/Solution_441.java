package com.leetcode.binarySearch;

/**
 * @author lwj
 * @date 2020/8/3 20:05
 */
public class Solution_441 {
    public static int arrangeCoins(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum+=i;
            if(n-sum<=i){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
    }
}
