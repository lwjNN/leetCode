package com.leetcode.everyday.july;

import java.util.Stack;

/**
 * @author LWJ
 * @date 2020/7/4 14:38
 */
public class Solution_04 {
    public static int longestValidParentheses(String s) {
        int res = 0;
        int tmp = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (stack.size() == 0) {
                    tmp = 0;
                }
                stack.push(s.charAt(i));
            } else {
                if (stack.size() != 0) {
                    stack.pop();
                    tmp += 2;
                } else {
                    res = Math.max(res, tmp);
                }
            }
        }
        return res;
    }

    public static int longestValidParentheses_1(String s) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int len = s.length() - 1;
        int res = 0;
        for (int i = 0; i <= len; i++) {
            if (s.charAt(i) == '(') {
                stack1.push(s.charAt(i));
                stack2.push(i);
            } else {
                if (stack1.size() != 0) {
                    stack1.pop();
                    stack2.pop();
                } else {
                    stack2.push(i);
                }
            }
        }
        if (stack2.isEmpty()) {
            return len + 1;
        }
        if(stack2.size() == s.length()){
            return 0;
        }
        int size = stack2.size();
        int[] arr = new int[size+2];
        arr[0] = -1;
        arr[arr.length-1] = s.length();
        for (int i = size; i >0 ; i--) {
            arr[i] = stack2.pop();
        }
        for (int i = 1; i < arr.length; i++) {
            res = Math.max(res,arr[i]-arr[i-1]-1);
        }
        return res;
    }


    public boolean chargeIvalid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses_1("()(()(()()"));
    }
}
