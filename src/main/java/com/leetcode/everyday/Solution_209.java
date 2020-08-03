package com.leetcode.everyday;

import java.util.Arrays;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/6/28 9:15
 */
public class Solution_209 {
    public static int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;;
        int pre = 0;
        int last = 0;
        int sum = 0;
        while (pre < len) {
            sum += nums[pre];
            while(sum>=s){
                minLen = Math.min(minLen,pre - last +1);
                sum -= nums[last];
                last++;
            }
            pre++;
        }
        return minLen == Integer.MAX_VALUE?0:minLen;

    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(minSubArrayLen(12, arr));
    }

}
