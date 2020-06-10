package com.leetcode.sword2offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * 限制：
 * 0 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/6/3 11:35
 */
//使用二分
public class Solution_53_1 {
    /**
     * 利用二分查找目标值左右下标位置相减即为出现次数
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return helper(nums,target) - helper(nums,target-1);
    }

    public int helper(int[] num, int tar) {
        int i = 0, j = num.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (num[mid] <= tar){
                i = mid +1;
            }else{
                j = mid-1;
            }
        }
        return i;
    }
}
