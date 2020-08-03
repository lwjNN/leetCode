package com.leetcode.sword2offer;

import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/6/8 10:25
 */
public class Solution_57_1 {
    //普通思路，双重遍历，每次遍历，就查询数组剩下的元素是否等于target-nums[i]
    //时间复杂度O（NlogN）
    public int[] twoSum(int[] nums, int target) {
        if (nums[0] > target) {
            return new int[0];
        }
        int[] arr = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int res = target - nums[i];
            int search = Arrays.binarySearch(nums, res);
            if (search > 0) {
                arr[0] = nums[i];
                arr[1] = nums[search];
            }
        }
        return arr;
    }

    //前后双指针
    public int[] twoSum_2index(int[] nums, int target) {
        int pre = 0;
        int last = nums.length - 1;
        while (pre < last) {
            int s = nums[pre] + nums[last];
            if (s < target) {
                pre++;
            }else if(s>target){
                last--;
            }else{
                return new int[]{nums[pre],nums[last]};
            }
        }
        return new int[0];
    }
}
