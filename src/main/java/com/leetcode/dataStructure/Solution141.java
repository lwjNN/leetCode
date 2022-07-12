package com.leetcode.dataStructure;

import com.leetcode.sword2offer.offer.ListNode;

/**
 * @author lwj
 * @date 2022/6/18 18:28
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

}



