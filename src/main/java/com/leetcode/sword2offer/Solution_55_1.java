package com.leetcode.sword2offer;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author LWJ
 * @date 2020/6/4 18:51
 */
public class Solution_55_1 {

    //递归
    public int maxDepth_Recursive(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth_Recursive(root.left),maxDepth_Recursive(root.right)) + 1;
    }

    //广度优先 bfs
    public int maxDepth_bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                size--;
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }

            res++;
        }
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
