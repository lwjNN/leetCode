package com.leetcode.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LWJ
 * @date 2020/6/26 10:16
 */
public class Solution_0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode resNode = new ListNode(0);
        ListNode cur = resNode;
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head.val)) {
                set.add(head.val);
                cur.next = new ListNode(head.val);
                cur = cur.next;
            }
            head = head.next;
        }
        return resNode.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void forEach(ListNode listNode) {
        while (listNode != null){
            System.out.print(listNode.val+ " ");
            listNode = listNode.next;
        }
    }


    public static void main(String[] args) {
        Solution_0201 s = new Solution_0201();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(3);
        node1.next.next.next.next = new ListNode(2);
        node1.next.next.next.next.next = new ListNode(1);

        ListNode listNode = s.removeDuplicateNodes(node1);
        forEach(listNode);

    }
}
