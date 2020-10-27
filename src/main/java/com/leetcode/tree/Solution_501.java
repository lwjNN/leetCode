package com.leetcode.tree;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author lwj
 * @date 2020/9/24 15:17
 */
public class Solution_501 {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        inorder(root, map);
        //map遍历
        //此处省略
        return new int[]{};
    }

    public void inorder(TreeNode node, Map<Integer, Integer> map){
        if(null == node){
            return;
        }
        inorder(node.left, map);
        if(map.get(node.val) != null){
            map.put(node.val, map.get(node.val) +  1);
        }else{
            map.put(node.val,1);
        }
        inorder(node.right, map);
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

