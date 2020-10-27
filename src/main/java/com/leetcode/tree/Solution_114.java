package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 例如，给定二叉树
 * <p>
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/9/11 16:58
 */
public class Solution_114 {

    /**
     * 迭代遍历。根据前序遍历改变原有的root节点
     * 时间，空间都是O(n)
     * @param root
     */
    public void flatten_1(TreeNode root) {
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            queue.offer(pop);
            if(pop.right != null){
                stack.push(pop.right);
            }
            if(pop.left != null){
                stack.push(pop.left);
            }
        }
        //把根节点去掉
        queue.poll();
        TreeNode tmp = root;
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            tmp.left = null;
            tmp.right = new TreeNode(poll.val);
            tmp = tmp.right;
        }
    }

    /**
     * 根据前驱节点，动态改变root的节点
     * @param root
     */
    public void flatten(TreeNode root){

        TreeNode cur = root;
        while (cur!=null){
            if(cur.left != null){
                TreeNode next = cur.left;
                TreeNode preNode = next;
                while (preNode.right != null){
                    preNode = preNode.right;
                }
                preNode.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
