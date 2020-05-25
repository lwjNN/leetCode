package com.leetcode.everyday;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_50 {

    /**
     * 这种方法老是超时、栈溢出
     * java.lang.StackOverflowError
     * 1.00000
     * -2147483648
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }
        if (n % 2 == 1) {
            return x * myPow(x, (n - 1));
        } else {
            double temp = myPow(x, n / 2);
            return temp * temp;
        }
    }


    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static double myPow1(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static void main(String[] args) {
        double v = myPow(1.00000, -2147483648);
        System.out.println(v);
    }

}
