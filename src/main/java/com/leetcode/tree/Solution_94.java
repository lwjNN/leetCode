package com.leetcode.tree;

import java.util.*;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *  1
 *   \
 *     2
 *    /
 *   3
 * <p>
 * 输出: [1,3,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/9/14 11:00
 */
public class Solution_94 {
    List<Integer> list = new ArrayList<>();
    /**
     * 深度优先，递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_dfs(TreeNode root) {
        if(root == null){
            return list;
        }
        inorderTraversal_dfs(root.left);
        list.add(root.val);
        inorderTraversal_dfs(root.right);
        return list;
    }

    /**
     * 广度优先，队列
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_bfs(TreeNode root) {
        if(root == null){
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        while ( root != null || !queue.isEmpty()){
            while (root != null){
                queue.push(root);
                root = root.left;
            }
            root = queue.poll();
            list.add(root.val);
            root = root.right;
        }
        return list;
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
