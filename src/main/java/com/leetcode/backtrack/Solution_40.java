package com.leetcode.backtrack;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/9/17 14:39
 */
public class Solution_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        int len = candidates.length;
        if (len == 0) {
            return resList;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        backtrack_error(candidates, target, 0, path, used, resList);
        return resList;
    }

    public List<List<Integer>> combinationSum2_OK(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        int len = candidates.length;
        if (len == 0) {
            return resList;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        backtrack_right(candidates, target, 0, path, resList);
        return resList;
    }

    public void backtrack_right(int[] candidates, int target, int index, Deque<Integer> path, List<List<Integer>> resList) {
        if (target == 0) {
            resList.add(new ArrayList<>(path));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            backtrack_right(candidates, target - candidates[i], i + 1, path, resList);
            path.removeLast();
        }
    }

    /**
     * 这种使用used的方法，无法去除重复元素的结果集，
     * @param candidates
     * @param target
     * @param index
     * @param path
     * @param used
     * @param resList
     */
    public void backtrack_error(int[] candidates, int target, int index, Deque<Integer> path, boolean[] used, List<List<Integer>> resList) {
        if (target == 0) {
            resList.add(new ArrayList<>(path));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
//            if (i > index && candidates[i] == candidates[i - 1]) {
//                continue;
//            }
            if (!used[i]) {
                used[i] = true;
                path.addLast(candidates[i]);
                System.out.println("递归前->" + path);
                System.out.println("递归前->" + Arrays.toString(used));
                backtrack_error(candidates, target - candidates[i], i, path, used, resList);
                path.removeLast();
                used[i] = false;
                System.out.println("递归后->" + path);
                System.out.println("递归前->" + Arrays.toString(used));
            }
        }
    }

    public static void main(String[] args) {
        Solution_40 s = new Solution_40();
        List<List<Integer>> lists = s.combinationSum2_OK(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(lists);
    }
}
