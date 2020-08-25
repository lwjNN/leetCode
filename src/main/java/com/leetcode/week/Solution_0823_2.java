package com.leetcode.week;

import java.util.Arrays;

/**
 * @author lwj
 * @date 2020/8/23 10:28
 */
public class Solution_0823_2 {
    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int[] newArr = new int[piles.length];
        int index = 0;
        for (int i = 0; i < piles.length; i=i+3) {
            newArr[i] = piles[piles.length-index-1];
            newArr[i+1] = piles[piles.length-index-2];
            newArr[i+2] = piles[index];
            index = index +2;
        }
        System.out.println(Arrays.toString(newArr));
        int result = 0;
        for (int i = 1; i < newArr.length; i=i+3) {
            result+= newArr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{1,2,2,4,7,8}));
    }
}
