package com.leetcode.dfs_bfs;

/**
 * @author lwj
 * @date 2020/8/17 20:10
 */
public class Solution_110 {

    //自顶向下递归
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    public int getDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }


    //自底向上递归
    public boolean isBalanced_1(TreeNode root) {
        return height(root)>=0;
    }

    public int height(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }else{
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
