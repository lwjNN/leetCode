package com.leetcode.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lwj
 * @date 2020/10/30 10:11
 */
public class Solution_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> resList = new ArrayList<>();
        if (s.length() == 0) {
            return resList;
        }
        Deque<String> deque = new ArrayDeque<>();
        backtrace(s, 0, 1, resList, deque);
        return resList;
    }

    private void backtrace(String s, int left, int right, List<List<String>> resList, Deque<String> deque) {
        if (left >= s.length()) {
            resList.add(new ArrayList<>(deque));
            return;
        }
        for (int i = left; i < s.length(); i++) {
            String substring = s.substring(left, 1 + i);
            if(isPalindrome(substring)){
                deque.addLast(substring);
                backtrace(s, 1 + i, right + i + 1, resList, deque);
                deque.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s);
        if (sb.reverse().toString().equals(s)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution_131 s = new Solution_131();
        System.out.println(s.partition("aabb"));
    }
}
