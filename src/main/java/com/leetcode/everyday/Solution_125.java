package com.leetcode.everyday;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/6/19 0:02
 */
public class Solution_125 {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || "".equals(s.trim())) {
            return true;
        }
        s = s.toLowerCase();
        int pre = 0;
        int last = s.length() - 1;
        while (pre <= last) {
            char c1 = s.charAt(pre);
            char c2 = s.charAt(last);

            if (isNumberOrLetter(c1) && isNumberOrLetter(c2) && c1 == c2) {
                pre++;
                last--;
            } else if (c1 == ' ' || !isNumberOrLetter(c1)) {
                pre++;
            } else if (c2 == ' ' || !isNumberOrLetter(c2)) {
                last--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isNumberOrLetter(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution_125 s = new Solution_125();
        System.out.println(s.isPalindrome("`l;`` 1o1 ??;l`"));
    }
}
