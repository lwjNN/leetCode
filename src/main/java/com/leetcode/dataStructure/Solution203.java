package com.leetcode.dataStructure;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2022/6/20 20:01
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode(-1);
        ListNode tmp = ans;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != val) {
                tmp.next = cur;
            } else {
                tmp.next = cur.next;
            }
            cur = cur.next;
            tmp = tmp.next;
        }
        return ans.next;

    }
}
