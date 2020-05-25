package com.leetcode.sword2offer;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/5/20 9:21
 */
public class Solution_07 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 前序遍历--根左右，
     * 中序遍历--左根右
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        int length1 = inorder.length;
        if (length == 0 || length1 == 0 || Integer.compare(length, length1) != 0) {
            return null;
        }
        if (length == 1) {
            return new TreeNode(preorder[0]);
        }
        //确定根节点
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 0; i < length1; i++) {
            if (inorder[i] == preorder[0]) {
                //在中序列表里查找根元素下标
                index = i;
            }
        }
        //取出左子树的前序遍历
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, index + 1);
        //取出左子树的中序遍历
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, index);
        //生成左子树
        root.left = buildTree(leftPreOrder, leftInOrder);

        //取出右子树的前序遍历列表
        int[] rightPreOrder = Arrays.copyOfRange(preorder, index + 1, length);
        //取出右子树的中序遍历列表
        int[] rightInOrder = Arrays.copyOfRange(inorder, index + 1, length1);
        //生成右子树
        root.right = buildTree(rightPreOrder, rightInOrder);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
//        TreeNode treeNode = buildTree(preorder, inorder);

    }

}
