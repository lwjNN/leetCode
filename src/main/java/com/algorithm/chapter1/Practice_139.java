package com.algorithm.chapter1;

import java.util.Stack;

/**
 * 用左括号补全表达式
 */
public class Practice_139 {
    public static String getLastStr(String str) {
        Stack<String> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if(c != ')'){
                stack.push(String.valueOf(c));
            }else{
                String val = stack.pop();
                String op = stack.pop();
                val = "(" + stack.pop() + op + val + ")";
                stack.push(val);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String lastStr = getLastStr("1+2)*3-4)*5-6)))");
        System.out.println(lastStr);
    }
}
