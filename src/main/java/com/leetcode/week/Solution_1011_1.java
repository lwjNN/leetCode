package com.leetcode.week;

import java.util.Stack;

/**
 * @author lwj
 * @date 2020/10/11 10:29
 */
public class Solution_1011_1 {
    public static int maxDepth(String s) {
        if(s.length() ==1 || s.indexOf("(") < 0){
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                max = Math.max(max, stack.size());
                stack.pop();
            }else {
                continue;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
