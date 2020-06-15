package com.leetcode.everyday;

import java.util.Arrays;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 
 * temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/6/11 20:10
 */
public class Solution_739 {

    public static int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] arr = new int[len];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (T[j] > T[i]) {
                    arr[i] = j - i;
                    break;
                }
                if (j == len - 1) {
                    arr[i] = 0;
                }
            }
        }
        arr[len - 1] = 0;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        int[] ints = dailyTemperatures(arr);
        System.out.println(Arrays.toString(ints));
    }
}
