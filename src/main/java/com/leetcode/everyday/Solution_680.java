package com.leetcode.everyday;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/5/19 9:19
 */
public class Solution_680 {

    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int pre = 0, last = chars.length - 1;
        Boolean b = true;
        while (pre < last) {
            if (chars[pre] == chars[last]) {
                pre++;
                last--;
            } else if (last - pre == 1) {
                return true;
            } else {
                if (b && chars[pre] == chars[last - 1] || chars[pre + 1] == chars[last]) {
                    b = false;
                    return validPalindrome(s.substring(pre,last-1)) || validPalindrome(s.substring(pre + 1,last));
                }
                if (b && chars[pre] == chars[last - 1]) {
                    b = false;
                    last--;
                } else if (b && chars[pre + 1] == chars[last]) {
                    b = false;
                    pre++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validPalindrome_reverse(String s) {
        if(s.length()<3){
            return true;
        }

        if(s.charAt(0) == s.charAt(s.length()-1)){
            return validPalindrome_reverse(s.substring(1,s.length()-1));
        }else if(s.charAt(0) == s.charAt(s.length()-2) && s.charAt(1) == s.charAt(s.length()-1)){
            return validPalindrome_reverse(s.substring(0,s.length()-1)) || validPalindrome_reverse(s.substring(1,s.length()-1));
        } else if(s.charAt(0) == s.charAt(s.length()-2)){
            return validPalindrome_reverse(s.substring(0,s.length()-1));
        }else if(s.charAt(1) == s.charAt(s.length()-1)){
            return validPalindrome_reverse(s.substring(1,s.length()-1));
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String ss = "ebcbbececabbacecbbcbe";
        System.out.println(validPalindrome(ss));

    }
}
