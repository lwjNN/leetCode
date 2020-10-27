package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * <p>
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 * <p>
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * <p>
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * 提示：
 * <p>
 * 给定的两颗树可能会有 1 到 200 个结点。
 * 给定的两颗树上的值介于 0 到 200 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/8/29 10:55
 */
public class Solution_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        helper(root1, list1);
        helper(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if(!list1.get(i).equals(list2.get(i))){
                return false;
            }
        }
        return true;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        helper(root.left, list);
        helper(root.right, list);
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
