package com.leetcode.week;

import java.util.Stack;

/**
 * @author lwj
 * @date 2020/8/9 10:31
 */
public class Solution_5483 {
    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else if(Math.abs(stack.peek()-s.charAt(i))==32){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(makeGood("hHcOzoC"));
    }
}
