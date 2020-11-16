package com.leetcode.backtrack;

import java.util.*;


/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/10/29 9:49
 */
public class Solution_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums.length == 0) {
            return resList;
        }
        Arrays.sort(nums);
        Deque<Integer> deque = new ArrayDeque<>();
        resList.add(new ArrayList<>(deque));
        boolean[] used = new boolean[nums.length];
        backtrack(nums, 0, resList, deque, used);
        return resList;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> resList, Deque<Integer> deque, boolean[] used) {

        for (int i = index; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            deque.addLast(nums[i]);
            used[i] = true;
            resList.add(new ArrayList<>(deque));
            backtrack(nums, i + 1, resList, deque, used);
            deque.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution_90 s = new Solution_90();
        System.out.println(s.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
