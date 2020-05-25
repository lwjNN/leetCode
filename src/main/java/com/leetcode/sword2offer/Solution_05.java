package com.leetcode.sword2offer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author LWJ
 * @date 2020/5/18 21:40
 */
public class Solution_05 {

    public static String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if(c == ' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        String s1 = replaceSpace(s);
        System.out.println(s1);
    }
}
