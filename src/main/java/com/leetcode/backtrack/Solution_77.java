package com.leetcode.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/9/22 9:46
 */
public class Solution_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        if (n == 0 || n < k) {
            return resList;
        }
        Deque<Integer> path = new ArrayDeque<>();
        backTrack(n, 1, path, k, resList);
        return resList;

    }

    public void backTrack(int n, int index, Deque<Integer> path, int k, List<List<Integer>> resList) {
        if (path.size() == k) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n; i++) {
            path.addLast(i);
            backTrack(n, i+1, path, k, resList);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution_77 s = new Solution_77();
        List<List<Integer>> combine = s.combine(4, 2);
        System.out.println(combine);
    }
}
