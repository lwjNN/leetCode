package com.leetcode.sword2offer;

import java.util.Arrays;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author LWJ
 * @date 2020/6/18 10:07
 */
public class Solution_59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len == 0){
            return nums;
        }
        int left = 0;
        int right = k-1;
        int[] res = new int[len-k+1];
        for (int j = right; j < len; j++) {
            int[] ints = Arrays.copyOfRange(nums, left, right+1);
            int max = getMax(ints);
            res[left] = max;
            left++;
            right++;
        }
        return res;
    }

    public int getMax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max<arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution_59_1 s = new Solution_59_1();
        int[] arr = {};
        int[] ints = s.maxSlidingWindow(arr, 0);
        System.out.println(Arrays.toString(ints));
    }
}
