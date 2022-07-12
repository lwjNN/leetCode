package com.leetcode.sword2offer.offer;

/**
 * @author lwj
 * @date 2022/5/7 15:34
 */
public class Offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode(head.val);
        ListNode tmp = head;
        while (tmp != null){
            int val = res.next.val;
            ListNode newNode = new ListNode(val);
            newNode.next = res;
            res = newNode;
            tmp = tmp.next;
        }
        return res;
    }


    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode behind = null;
        while (cur != null){
            behind = cur.next;
            cur.next = pre;
            pre = cur;
            cur = behind;
        }
        return pre;
    }
}




