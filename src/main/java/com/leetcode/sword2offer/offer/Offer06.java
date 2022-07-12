package com.leetcode.sword2offer.offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author lwj
 * @date 2022/5/6 09:35
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (head != null){
            stack.add(head.val);
            head = head.next;
            i++;
        }
        int[] res = new int[i];
        for (int j = 0; j < res.length; j++) {
            res[j] = stack.pop();
        }
        return res;
    }
}

