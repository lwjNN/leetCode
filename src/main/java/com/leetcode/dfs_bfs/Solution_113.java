package com.leetcode.dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/9/9 17:35
 */
public class Solution_113 {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return resList;
        }
        LinkedList<Integer> list = new LinkedList<>();
        bfs(root, sum, list);
        return resList;
    }

    public void bfs(TreeNode root, int sum, LinkedList<Integer> list){
        if(root == null) return;
        list.addLast(root.val);
        if (root.left == null && root.right == null && root.val == sum){
            resList.add(new ArrayList<>(list));
        }
        bfs(root.left, sum-(root.val), list);
        bfs(root.right, sum-(root.val), list);
        list.removeLast();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        Solution_113 s = new Solution_113();
        List<List<Integer>> lists = s.pathSum(root, 9);
    }
}
