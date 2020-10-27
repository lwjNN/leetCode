package com.leetcode.tree;

import java.util.Arrays;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/9/9 11:19
 */
public class Solution_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        if (length == 0){
            return null;
        }
        int rootVal = postorder[length - 1];
        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        for (int i = 0; i < length; i++) {
            if(inorder[i] == rootVal){
                index = i;
            }
        }
        int[] inorder_left = Arrays.copyOfRange(inorder, 0, index);
        int[] postorder_left = Arrays.copyOfRange(postorder, 0, index);
        root.left = buildTree(inorder_left, postorder_left);
        int[] inorder_right = Arrays.copyOfRange(inorder, index + 1, length);
        int[] postorder_right = Arrays.copyOfRange(postorder, index, length-1);
        root.right = buildTree(inorder_right, postorder_right);
        return root;
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
        Solution_106 s = new Solution_106();
        int[] inorder = {9,3,15,20,7};
        int[] postorder  = {9,15,7,20,3};
        s.buildTree(inorder, postorder);
    }
}
