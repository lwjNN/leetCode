package com.leetcode.everyday.july;

import com.leetcode.util.TreeNode;

/**
 * @author LWJ
 * @date 2020/7/7 9:11
 */
public class Solution_112 {
    boolean res = false;

    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return false;
//        }
//        if (root.left == null && root.right == null) {
//            if (sum == root.val) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        recur(root, sum);
        return res;
    }

    public void recur(TreeNode root, int tar) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && tar == root.val) {
            res = true;
        }
        recur(root.left, tar - root.val);
        recur(root.right, tar - root.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}



