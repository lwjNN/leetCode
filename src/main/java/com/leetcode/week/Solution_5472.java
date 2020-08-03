package com.leetcode.week;

import java.util.Arrays;

/**
 * @author LWJ
 * @date 2020/7/26 10:31
 */
public class Solution_5472 {
    public String restoreString(String s, int[] indices) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(findIndex(i,indices)));
        }
        return sb.toString();
    }


    public int findIndex(int tag, int[] arr){
        int index = 0;
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] == tag){
                index = j;
            }
        }
        return index;
    }
}
