package com.leetcode.everyday;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_69 {

    public static int mySqrt(int x) {
        if (x == 0) {
            return x;
        }
        int res = 1;
        for (int i = 1; i <= (x >> 1); i++) {
            if (i * i == x) {
                return i;
            }
            if (i * i < x) {
                res = i;
                continue;
            } else {
                res = i - 1;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = 99;
        int i1 = mySqrt(999);
        System.out.println(i1);
    }
}
