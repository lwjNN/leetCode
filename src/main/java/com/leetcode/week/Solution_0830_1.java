package com.leetcode.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lwj
 * @date 2020/8/30 10:21
 */
public class Solution_0830_1 {
    public static boolean containsPattern(int[] arr, int m, int k) {
        int length = arr.length;
        if(m * k>length){
            return false;
        }
        for (int i = 0; i <= length-m*k; i++) {
            int[] copy = Arrays.copyOfRange(arr, i, i + m );
            int[] copy1 = Arrays.copyOfRange(arr, i, i + m*k );
            for (int j = m; j < copy1.length; j++) {
                if(j == length-1 && copy1[j] != copy[j%m]){
                    return false;
                }
                else if(j != copy1.length-1 && copy1[j] != copy[j%m]){
                    break;
                }else if(j == copy1.length-1 && copy1[j] == copy[j%m]){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {2,1,2,2,2,2,2,2};
        System.out.println(containsPattern(arr, 2, 2));
    }
}
