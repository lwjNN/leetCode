package com.leetcode.tree;

import java.util.*;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/9/16 10:32
 */
public class Solution_46 {
    List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> permute_1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return resList;
        }
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        helper(nums, len, 0, path, used);
        return resList;
    }

    public void helper(int[] nums, int len, int depth, Deque<Integer> deque, boolean[] used) {
        if (depth == len) {
            resList.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                deque.addLast(nums[i]);
                used[i] = true;
                System.out.println("递归之前 =>" + deque);
                System.out.println("递归之前 used[]=>" + Arrays.toString(used));
                System.out.println("i="+ i);
                System.out.println("depth="+ depth);
                helper(nums, len, depth + 1, deque, used);
                used[i] = false;
                deque.removeLast();
                System.out.println("i="+ i);
                System.out.println("递归之后 =>" + deque);
                System.out.println("递归之后 used[]=>" + Arrays.toString(used));
            }
        }
    }

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return res;
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int deepth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if(deepth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,deepth + 1, path, used, res);
            used[i] = false;
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        Solution_46 s = new Solution_46();
        List<List<Integer>> lists = s.permute_1(new int[]{1, 2, 3});
        System.out.println(lists);
    }
}
