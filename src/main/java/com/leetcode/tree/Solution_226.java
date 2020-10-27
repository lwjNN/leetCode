package com.leetcode.tree;

/**
 * @author lwj
 * @date 2020/9/16 9:19
 */
public class Solution_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tmp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tmp);
        return root;
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
