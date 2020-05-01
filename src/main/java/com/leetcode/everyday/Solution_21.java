package com.leetcode.everyday;

//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4

public class Solution_21 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 分别判断两个链表的值大小逐一比较加入新的链表
     * 迭代方法
     * 时间复杂度 O(n+m)
     * 空间复杂度 O(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    /**
     * 递归调用
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoListRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoListRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListRecursive(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        Solution_21 so = new Solution_21();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode lists = mergeTwoListRecursive(l1, l2);
        while (lists != null) {
            System.out.println(lists.val);
            lists = lists.next;
        }
    }

}
