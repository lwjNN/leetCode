package com.leetcode.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/9/23 10:27
 */
public class Solution_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        resList.add(new ArrayList<>());
        if (nums.length == 0) {
            return resList;
        }
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(nums, path, 0, resList);
        return resList;
    }

    public void backtrack(int[] nums, Deque<Integer> path, int index, List<List<Integer>> resList) {
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.addLast(nums[i]);
            resList.add(new ArrayList<>(path));
            backtrack(nums, path, i + 1, resList);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution_78 s = new Solution_78();
        List<List<Integer>> subsets = s.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);

        System.out.println(1<<3);
    }
}
