package com.leetcode.sword2offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * 提示：
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author LWJ
 * @date 2020/6/22 19:11
 */
public class Solution_65 {
    public static int add(int a, int b) {
        while (b!=0){
            int c = (a&b)<<1;
            a=a^b;
            b=c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(7, 15));
    }
}
