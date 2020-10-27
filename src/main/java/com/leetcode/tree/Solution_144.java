package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *  示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/9/10 15:40
 */
public class Solution_144 {
    List<Integer> resList = new ArrayList<>();
    //递归，深度优先搜索
    public List<Integer> preorderTraversal_1(TreeNode root) {
        if (root == null){
            return resList;
        }
        resList.add(root.val);
        preorderTraversal_1(root.left);
        preorderTraversal_1(root.right);
        return resList;
    }

    //广度优先搜索
    public List<Integer> preorderTraversacl_bfs(TreeNode root) {
        List<Integer> resList = new LinkedList<>();
        if (root == null){
            return resList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            resList.add(pop.val);
            if(pop.right != null){
                stack.push(pop.right);
            }
            if(pop.left != null){
                stack.push(pop.left);
            }
        }
        return resList;
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
