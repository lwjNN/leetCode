//package com.leetcode.week;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author lwj
// * @date 2020/11/8 10:27
// */
//public class Solution_1108_2 {
//    public int minDeletions(String s) {
//        if(s.length() == 1){
//            return 0;
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if(map.get(s.charAt(i)) == null){
//                map.put(s.charAt(i), 1);
//            }else{
//                map.put(s.charAt(i), map.get(s.charAt(i)) +1);
//            }
//        }
//        int[] arr = new int[map.size()];
//        int index = 0;
//        for (Character c:map.keySet()){
//            arr[index++] = map.get(c);
//        }
//        Arrays.sort(arr);
//    }
//}
