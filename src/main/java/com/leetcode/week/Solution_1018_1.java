package com.leetcode.week;

/**
 * @author lwj
 * @date 2020/10/18 10:28
 */
public class Solution_1018_1 {
    public static int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)){
                    max = Math.max(max,j-i-1);
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("cabbac"));
    }
}
