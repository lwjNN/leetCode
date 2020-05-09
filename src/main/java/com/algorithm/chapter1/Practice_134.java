package com.algorithm.chapter1;

import java.util.Stack;

/**
 * 第一章 page102 习题1.3.4
 * <p>
 * {[([])]}
 * {([)]}
 */
public class Practice_134 {

    public boolean parentheses(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean b = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '{' || chars[i] == '[' || chars[i] == '(') {
                stack.push(chars[i]);
                continue;
            }
            if (chars[i] == ')' && stack.pop() != '('){
                break;
            }else if(chars[i] == ']' && stack.pop() != '['){
                break;
            }else if(chars[i] == '}' && stack.pop() != '{'){
                break;
            }else {
                b = true;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        String str = "{(]}";
        Practice_134 p = new Practice_134();
        boolean parentheses = p.parentheses(str);
        System.out.println(parentheses);
    }
}
