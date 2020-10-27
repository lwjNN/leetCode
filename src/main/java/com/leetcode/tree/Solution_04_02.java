package com.leetcode.tree;

import java.util.Arrays;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author lwj
 * @date 2020/9/1 10:20
 */
public class Solution_04_02 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums);
    }

    public TreeNode buildTree(int[] nums){
        if(nums.length == 0){
            return null;
        }
        if(nums.length == 1){
            return new TreeNode(nums[0]);
        }
        int length = nums.length;
        int start = 0;
        int end = length-1;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] left = Arrays.copyOfRange(nums, start, mid);
        root.left = buildTree(left);
        int[] right = Arrays.copyOfRange(nums, mid+1, length);
        root.right = buildTree(right);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] ints = Arrays.copyOfRange(arr, 2, 4);
        System.out.println(Arrays.toString(ints));
    }
}
