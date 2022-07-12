//package com.leetcode.dataStructure;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @author lwj
// * @date 2022/6/16 17:57
// */
//public class Solution36 {
//    public boolean isValidSudoku(char[][] board) {
//        boolean ans = true;
//        //1、遍历所有行 看是否符合
//        for (int i = 0; i < board.length; i++) {
//            ans = ans && helper(board[i]);
//        }
//        if (!ans) return false; //如果某一行不满足 直接返回
//        //2、遍历所有列
//        char[] tmp = new char[board[0].length];
//        for (int i = 0; i < board[0].length; i++) {
////            tmp[i] = board[i]
//        }
//        //3、遍历9个九宫格
//    }
//
//    public boolean helper(char[] arr) {
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < arr.length; i++) {
//            set.add(arr[i]);
//        }
//        return set.size() == arr.length;
//    }
//}
