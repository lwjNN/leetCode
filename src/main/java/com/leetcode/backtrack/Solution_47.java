package com.leetcode.backtrack;

import java.text.ParseException;
import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/9/17 16:40
 */
public class Solution_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> resList = new ArrayList<>();
        if (len == 0) {
            return resList;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(nums, 0, path, used, resList);
        return resList;
    }

    public void backtrack(int[] nums, int index, Deque<Integer> path, boolean[] used, List<List<Integer>> resList) {
        if (index == nums.length) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i-1])) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            System.out.println("递归之前 =>" + path);
            System.out.println("递归之前 used[]=>" + Arrays.toString(used));
            backtrack(nums, index + 1, path, used, resList);
            path.removeLast();
            used[i] = false;
            System.out.println("递归之后 =>" + path);
            System.out.println("递归之后 used[]=>" + Arrays.toString(used));

        }
    }

    public static void main(String[] args) throws ParseException {
        Solution_47 s = new Solution_47();
        s.permuteUnique(new int[]{1,1,2});
    }
}
