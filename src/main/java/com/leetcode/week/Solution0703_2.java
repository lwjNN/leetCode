package com.leetcode.week;

/**
 * @author lwj
 * @date 2022/7/3 10:27
 */
public class Solution0703_2 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        ListNode tmp = head;
        int index = 0;
        int a = 1;
        while (tmp != null) {
            ans[index/n][index%n] = head.val;
        }
        return ans;
    }

}

class ListNode {
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
