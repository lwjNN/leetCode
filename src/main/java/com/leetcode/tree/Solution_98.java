package com.leetcode.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author lwj
 * @date 2020/9/3 19:38
 */
public class Solution_98 {
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {

//        return dfs(root, null, null);
        if (root == null) {
            return true;
        }
        helper(root);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i-1)>=list.get(i)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!dfs(root.left, lower, val)) return false;
        if (!dfs(root.right, val, upper)) return false;
        return true;
    }

    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
