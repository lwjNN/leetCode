//package com.leetcode.week;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
///**
// * @author LWJ
// * @date 2020/6/14 10:27
// */
//public class Solution_5438 {
//    public int minDays(int[] bloomDay, int m, int k) {
//        int len = bloomDay.length;
//        if (m * k > len) {
//            return -1;
//        }
//        if(m*k == len){
//            return getMax(bloomDay);
//        }
//
//        return 1;
//    }
//
//
//    public int getMax(int[] arr){
//        int max = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if(arr[i]>max){
//                max = arr[i];
//            }
//        }
//        return max;
//    }
//}
