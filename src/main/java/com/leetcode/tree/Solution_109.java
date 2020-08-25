package com.leetcode.tree;


/**
 * @author lwj
 * @date 2020/8/18 19:46
 */
public class Solution_109 {
    ListNode globaHead;

    public TreeNode sortedListToBST(ListNode head) {
        globaHead = head;
        int length = getLength(head);
        return buildTree(0, length-1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globaHead.val;
        globaHead = globaHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }


    /**
     * 分治+递归
     * 时间复杂度: O(nlogn)
     * 空间复杂度：O(logn)
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST_1(ListNode head) {
        return buildTree_1(head, null);
    }

    public TreeNode buildTree_1(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode median = getMedian(left, right);
        TreeNode root = new TreeNode(median.val);
        root.left = buildTree_1(left, median);
        root.right = buildTree_1(median.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
