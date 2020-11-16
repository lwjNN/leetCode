package com.leetcode.everyday;

/**
 * @author lwj
 * @date 2020/11/13 15:59
 */
public class Solution_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        ListNode tmp = next;
        while (cur.next != null && tmp.next != null){
            cur.next = cur.next.next;
            tmp.next = tmp.next.next;
            cur = cur.next;
            tmp = tmp.next;
        }
        cur.next = next;
        return head;
    }

    public static class ListNode {
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

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        Solution_328 s = new Solution_328();
        s.oddEvenList(node);
    }
}
