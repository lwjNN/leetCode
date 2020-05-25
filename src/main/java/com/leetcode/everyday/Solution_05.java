package com.leetcode.everyday;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/5/21 13:48
 */
public class Solution_05 {
    public  String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                String temp = s.substring(i,j);
                if(isPalindrome(temp) && temp.length() > max){
                    ans = temp;
                    max = Math.max(ans.length(),max);
                }
            }
        }
        return ans;
    }

    public  boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length >> 1; i++) {
            if (str.charAt(i) != str.charAt(length-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abcd";
//        String s = longestPalindrome(str);
//        System.out.println(s);
    }
}
