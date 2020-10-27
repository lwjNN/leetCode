package com.leetcode.tree;

/**
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回 false 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-balance-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author lwj
 * @date 2020/9/1 11:13
 */
public class Solution_04_04 {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right))+1;
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
