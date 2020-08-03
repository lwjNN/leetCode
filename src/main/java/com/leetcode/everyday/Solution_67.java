package com.leetcode.everyday;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/6/23 12:51
 */
public class Solution_67 {
    public static String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int max = Math.max(aLen, bLen);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max + 1; i++) {
            sb.append("0");
        }
        if (aLen > bLen) {
            for (int i = 0; i < aLen - bLen; i++) {
                b = "0" + b;
            }
        } else {
            for (int i = 0; i < bLen - aLen; i++) {
                a = "0" + a;
            }
        }
        for (int i = 0; i < max; i++) {
            int num1 = Integer.parseInt(String.valueOf(a.charAt(max - 1 - i)));
            int num2 = Integer.parseInt(String.valueOf(b.charAt(max - 1 - i)));
            int num3 = Integer.parseInt(String.valueOf(sb.charAt(max - i)));
            if (((num1 ^ num2) & num3) == 1) {
                //两个字符串第i+1位有一个是1，一个是0，并且对应结果字符串位也是1
                // 那么结果位置为0,需要进位。
                sb.setCharAt(max  - i, '0');
                sb.setCharAt(max - i - 1, '1');
            } else if ((num1 & num2) == 1) {
                //如果两字符串第i+1位都是1，
                // 那么结果位不变,需要进位
                sb.setCharAt(max - i -1, '1');
            } else if((num1 ^ num2) == 1 && num3 == 0){
                //倒数第i+1个字符如果都是0，结果位也是0;
                sb.setCharAt(max  - i, '1');
            }else {
                continue;
            }
        }
        return sb.charAt(0)=='0'?sb.toString().substring(1) : sb.toString();
    }

    public static void main(String[] args) {
        String a = "1111111";
        String b = "1";
        String s = addBinary(a, b);
        System.out.println(s);
    }
}
