package com.leetcode.sword2offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 *
 * @author LWJ
 * @date 2020/5/27 12:48
 */
public class Solution_22 {

    /**
     * 双指针思想，快指针先走k步，然后两指针一起走，快指针走完，慢指针所在则是指定的节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd_twoIndex(ListNode head, int k) {
        ListNode pre = head;
        ListNode last = head;
        int index = 1;
        while (index < k) {
            pre = pre.next;
            index++;
        }
        while (pre!=null){
            pre = pre.next;
            last = last.next;
        }
        return last;
    }

    /**
     * 常规思想，用一个链表数组，把所有的节点放进去，然后索引指定位置的节点即可
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (k > list.size()) {
            return null;
        }
        return list.get(list.size() - k);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
