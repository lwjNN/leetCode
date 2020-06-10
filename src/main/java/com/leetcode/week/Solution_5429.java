package com.leetcode.week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中的 k 个最强值
 * @author LWJ
 * @date 2020/6/7 11:36
 */
public class Solution_5429 {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int mid = (arr.length - 1) / 2;//中位数下标
        int[] temp = new int[k];
        int pre = 0;
        int last = arr.length -1;
        for (int i = 0; i < k; i++) {
            if(Math.abs(arr[pre]-arr[mid]) > (arr[last]) -arr[mid]){
                temp[i] = arr[pre++];
            }else{
                temp[i] = arr[last--];
            }
        }
        return temp;
    }
}
