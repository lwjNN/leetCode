package com.leetcode.sword2offer;

/**
 * @author LWJ
 * @date 2020/5/30 11:02
 */
public class Solution_27 {

    public  TreeNode mirrorTree(TreeNode root) {
        if (root.right == null && root.left == null){
            return root;
        }
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(root.left);
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

    public static void main(String[] args) {

    }

}
