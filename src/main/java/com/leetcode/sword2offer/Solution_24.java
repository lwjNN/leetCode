package com.leetcode.sword2offer;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 限制：
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/5/30 9:24
 */
public class Solution_24 {

    /**
     * 新增加一个外部链表，翻转。空间复杂度为O(n)
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode newNode = null;
        while (head != null) {
            ListNode newHead = new ListNode(head.val);
            newHead.next = newNode;
            newNode = newHead;
            head = head.next;
        }
        return newNode;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

