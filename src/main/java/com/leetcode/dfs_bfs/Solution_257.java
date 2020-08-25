package com.leetcode.dfs_bfs;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lwj
 * @date 2020/8/21 18:12
 */
public class Solution_257 {
    //迭代，广度优先
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        if(root == null){
            return paths;
        }
        LinkedList<TreeNode> node_stack = new LinkedList<>();
        LinkedList<String> path_stack = new LinkedList<>();
        node_stack.add(root);
        path_stack.add(String.valueOf(root.val));
        TreeNode node;
        String path;
        while (!node_stack.isEmpty()){
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            if(node.left == null && node.right == null){
                paths.add(path);
            }
            if(node.left != null){
                node_stack.add(node.left);
                path_stack.add(path+"->" + node.left.val);
            }
            if(node.right != null){
                node_stack.add(node.right);
                path_stack.add(path + "->" + node.right.val);
            }
        }
        return paths;
    }



    //递归调用，深度优先
    public List<String> binaryTreePaths_1(TreeNode root) {
        List<String> linkedList = new LinkedList<>();
        helper(root, "", linkedList);
        return linkedList;
    }

    public void helper(TreeNode root, String path, List<String> paths) {
        if (root != null){
            path += Integer.toString(root.val);
            if(root.left == null && root.right == null){
                paths.add(path);
            }else{
                path += "->";
                helper(root.left, path, paths);
                helper(root.right, path, paths);
            }
        }
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
