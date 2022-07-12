package com.leetcode.dataStructure;

import java.util.List;

/**
 * @author lwj
 * @date 2022/6/21 11:00
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, tmp;
        ListNode cur = head;
        while (cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
