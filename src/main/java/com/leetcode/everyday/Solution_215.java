package com.leetcode.everyday;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author LWJ
 * @date 2020/6/29 9:22
 */
public class Solution_215 {
    public static int findKthLargest1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]<nums[j]){
                    int tem = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tem;
                }
            }
        }
        return nums[k-1];
    }

    public static int findKthLargest2(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.out.println(findKthLargest1(arr, 2));
    }
}
