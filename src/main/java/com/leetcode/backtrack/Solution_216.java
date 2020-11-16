package com.leetcode.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author lwj
 * @date 2020/11/2 10:20
 */
public class Solution_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resList = new ArrayList<>();
        if(n == 0){
            return resList;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        backtrace(k, n, n,1, resList, deque);
        return resList;
        
    }

    private void backtrace(int k, int n, int target, int index, List<List<Integer>> resList, Deque<Integer> deque) {
        if(deque.size() == k && target <= 0){
            if(deque.size() == k && target == 0){
                resList.add(new ArrayList<>(deque));
                return;
            }
        }

        for (int i = index; i <= 9; i++) {
            deque.addLast(i);
            backtrace(k, n, target - i, i+1, resList, deque);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution_216 s = new Solution_216();
        System.out.println(s.combinationSum3(9, 45));
    }
}
