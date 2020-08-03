package com.leetcode.sword2offer;

import java.util.Arrays;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * 提示：
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/6/24 9:23
 */
public class Solution_66 {
    /**
     * 暴力法双重for循环是超时的
     *
     * @param a
     * @return
     */
    public int[] constructArr_1(int[] a) {
        int len = a.length;
        int[] res = new int[len];
        if (len < 2) {
            return a;
        }
        for (int i = 0; i < len; i++) {
            int left = arrayMutiply(Arrays.copyOfRange(a, 0, i));
            int right = arrayMutiply(Arrays.copyOfRange(a, i + 1, len));
            res[i] = left * right;
        }

        return res;
    }

    public int arrayMutiply(int[] arr) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            res *= arr[i];
        }
        return res;
    }


    /**
     * 使用动态规划，维护左右两个数组
     * 具体思路详见：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/mian-shi-ti-66-gou-jian-cheng-ji-shu-zu-biao-ge-fe/
     *
     * @param a
     */
    public static int[] constructArr_2(int[] a) {
        int len = a.length;
        if (len == 0) {
            return new int[0];
        }
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i]*right[i];
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6};
        int[] ints = constructArr_2(arr);
        System.out.println(Arrays.toString(ints));
    }
}
