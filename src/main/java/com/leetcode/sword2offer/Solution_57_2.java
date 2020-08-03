package com.leetcode.sword2offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * 限制：
 * 1 <= target <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/6/17 11:26
 */
public class Solution_57_2 {
    public static int[][] findContinuousSequence(int target) {
        int i = 1;//滑动窗口左区间
        int j = 1;
        int sum = 0;
        List<int[]> list = new ArrayList<>();
        while (i < target / 2) {
            if (sum < target) {
                //右窗口向右滑动
                sum += j;
                j++;
            } else if (sum > target) {
                //左窗口右滑动
                sum -= i;
                i++;
            }else{
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                list.add(arr);
                //左窗口继续向右滑动
                sum -= i;
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = findContinuousSequence(35);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
