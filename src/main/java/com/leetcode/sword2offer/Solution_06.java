package com.leetcode.sword2offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * @author LWJ
 * @date 2020/5/18 22:03
 */
public class Solution_06 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
//        node.next = new ListNode(3);
//        node.next.next = new ListNode(2);
        int[] ints = reversePrint(node);
        System.out.println(Arrays.toString(ints));
    }


    public static int[] reversePrint(ListNode head) {
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
            i++;
        }
        int[] arr = new int[i];
        while (!stack.isEmpty()) {
            arr[j++] = stack.pop();
        }
        return arr;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
