package com.leetcode.sword2offer;

/**
 *
 *
 * @author LWJ
 * @date 2020/6/17 10:05
 */
public class Solution_58_2 {
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0,n);
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
}
