package com.leetcode.everyday;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，
 * 一夜之内能够偷窃到的最高金额。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/5/29 10:17
 */
public class Solution_198 {

    //递归方法。这道题详解请参照:
    //https://www.bilibili.com/video/BV12W411v7rd
    public int rob_Recursive(int[] nums) {
        return inner(nums,nums.length);
    }
    public int inner(int[] nums,int i){
        if(i == 1){
            return nums[0];
        }
        if(i == 2){
            return Math.max(nums[0],nums[1]);
        }
        int A = inner(nums, i-2) + nums[i-1];
        int B = inner(nums, i-1);
        return Math.max(A,B);
    }

    public int rob_dp(int[] nums){
        int length = nums.length;
        if (length == 0){
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return dp[length-1];
    }

    public static void main(String[] args) {
        Solution_198 s = new Solution_198();
        int[] arr = {1,2,4,1,7,8,3};
        System.out.println(s.rob_dp(arr));
    }
}
