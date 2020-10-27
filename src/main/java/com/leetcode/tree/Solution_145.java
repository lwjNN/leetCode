package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwj
 * @date 2020/9/29 9:45
 */
public class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        dfs(root, ans);
        return ans;
    }

    public void dfs(TreeNode node,List<Integer> list){
        if(node == null){
            return;
        }
        dfs(node.left, list);
        dfs(node.right, list);
        list.add(node.val);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
