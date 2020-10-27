package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lwj
 * @date 2020/8/29 12:02
 */
public class Solution_897 {
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return root;
        }
        List<Integer> list = new LinkedList<>();
        BTS(root, list);
        TreeNode resNode = new TreeNode(list.get(0));
        TreeNode cur = resNode;
        for (int i = 1; i < list.size(); i++) {
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
        return resNode;

    }


    public void BTS(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        BTS(root.left,list);
        list.add(root.val);
        BTS(root.right,list);
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
