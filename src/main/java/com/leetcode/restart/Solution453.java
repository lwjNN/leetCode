package com.leetcode.restart;

/**
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 答案保证符合 32-bit 整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-moves-to-equal-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2022/7/12 21:45
 */
public class Solution453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (min < nums[i]){
                min = nums[i];
            }
        }
        int ans = 0;
        for (int num : nums){
            ans += num - min;
        }
        return ans;
    }
}
