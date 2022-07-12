package com.leetcode.restart;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 * <p>
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * nums 中的每个元素出现 一次 或 两次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-duplicates-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2022/7/6 10:27
 */
public class Solution442 {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 2){
            return ans;
        }
        for (int num : nums){
            int tmp = (num - 1) % n;
            nums[tmp] += n;
        }

        for (int i = 1; i <= n; i++) {
            if ((nums[i - 1] / n == 2 && nums[i - 1] % n > 0) || nums[i - 1] / n > 2){
                ans.add(i);
            }
        }
        return ans;
    }


    public static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums){
            if (nums[Math.abs(num) - 1] < 0){
                ans.add(Math.abs(num));
            }else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        return ans;
    }

    public static List<Integer> findDuplicates3(int[] nums){
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0){
                ans.add(Math.abs(nums[i]));
            }else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates3(new int[]{4,3,2,7,8,2,3,1}));
    }

}
