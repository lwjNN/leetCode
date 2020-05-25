package com.leetcode.everyday;

/**
 * @author LWJ
 * @date 2020/5/19 11:49
 */
public class Test {

    public  boolean validPalindrome(String s) {
        return valid(s, 0, s.length() - 1, false);
    }

    public  boolean valid(String s, int i, int j, boolean isDeep) {
        while (i < j) {
            char a = s.charAt(i), b = s.charAt(j);
            if (a != b ) {
                if(isDeep) return false;
                return valid(s, i, j - 1, true) || valid(s, i + 1, j, true);
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abac";
//        boolean b = validPalindrome(s);
//        System.out.println(b);
    }
}
